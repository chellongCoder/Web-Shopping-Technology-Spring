/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import com.starter.bean.Item;
import com.starter.bean.Store;
import com.starter.model.ItemModel;
import com.starter.model.StoreModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author chellong
 */
@Controller
@SessionAttributes({"StoreInfo", "ItemInfo"})
public class ShoppingController {

    public static final int ITEM_PER_PAGE = 15;

    @RequestMapping(value = "shopping.htm")
    public String shopping(ModelMap model, HttpServletRequest request) {

        try {

            StoreModel storeModel = new StoreModel();
            ItemModel itemModel = new ItemModel();
            Thread t1 = new Thread(() -> {
                try {
                    List<Store> listStore = storeModel.getAll();
                    model.addAttribute("StoreInfo", listStore);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            int currentPage = 1;
            if (request.getParameter("page") != null) {
                currentPage = Integer.parseInt(request.getParameter("page"));
            }
            model.addAttribute("currentPage", currentPage);
            int offset = (currentPage - 1) * ShoppingController.ITEM_PER_PAGE;
            model.addAttribute("ITEM_PER_PAGE", ITEM_PER_PAGE);
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int totalItems = itemModel.getCountPage();
                        model.addAttribute("totalItems", totalItems);
                        int count = (int) Math.ceil((double) totalItems / ShoppingController.ITEM_PER_PAGE);
                        model.addAttribute("totalPages", count);

                        List<Item> itemPerPage = itemModel.getItemPerPage(offset, ShoppingController.ITEM_PER_PAGE);
                        model.addAttribute("ItemInfo", itemPerPage);
                          
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "shopping";
    }

    @RequestMapping(value = "selectStore.htm")
    public String handleSelectStore(ModelMap model) {

        return "shopping";
    }
}
