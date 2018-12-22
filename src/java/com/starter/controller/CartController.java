/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import com.starter.bean.Item;
import com.starter.model.ItemModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author chellong
 */
@Controller
@SessionAttributes({"StoreInfo", "ItemInfo", "typeStore", "cartItem", "items"})
public class CartController {

    @RequestMapping(value = "cart.htm")
    
    public String cart(ModelMap model, HttpSession session) {
        try {
            ItemModel itemModel = ItemModel.getInstance();
            Map<Integer, Integer> map = (Map<Integer, Integer>) session.getAttribute("cartItem");
            if (map != null) {
                Map<Item, Integer> items = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    Item item = itemModel.getById(entry.getKey());
                    items.put(item, entry.getValue());
                    model.addAttribute("items", items);
                    System.out.println(entry.getKey() + "/" + entry.getValue());
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "cart";
    }

    @RequestMapping(value = "updateCart",  method = RequestMethod.POST)
    @ResponseBody
    public String updateCart(@RequestParam String quantities, ModelMap model, HttpSession session) {
        try {
            ItemModel itemModel =ItemModel.getInstance();
            System.out.println("quantities " + quantities);
            String[] array = quantities.split("[^0-9]");
            ArrayList<Integer> amount = new ArrayList<>();
            for (String string : array) {
                if(!string.trim().equals("")) {
                    System.out.println("string " + string);
                    amount.add(Integer.parseInt(string));
                }
            }
            int index = 0;
            Map<Integer, Integer> items = (Map<Integer, Integer>) session.getAttribute("cartItem");
            Map<Item, Integer> listItem = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
                Item item = itemModel.getById(entry.getKey());
                listItem.put(item, amount.get(index));
//                System.out.println("item " + entry.getKey());
//                entry.setValue(amount.get(index));
                index++;
            }
            model.addAttribute("items", listItem);
            JSONObject json = new JSONObject();
            json.putAll(listItem);
            return json.toJSONString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
    
    @RequestMapping(value = "updateTotals")
    public String updateTotal (ModelMap model, ServletRequest request) {
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        System.out.println("contry " + country + " state " + state);
        return "redirect:/cart.htm";
    }
}
