/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import com.starter.bean.Item;
import com.starter.model.ItemModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chellong
 */
@Controller
public class ManagerController {

    public static final int ITEM_PER_PAGE = 15;
    private ItemModel itemModel;

    @RequestMapping(value = "manager.htm")
    public String manager(HttpServletRequest request, ModelMap model) {
        try {
            int currentPage = 1;
            itemModel = ItemModel.getInstance();
            if (request.getParameter("page") != null) {
                currentPage = Integer.parseInt(request.getParameter("page"));
            }
            model.addAttribute("currentPage", currentPage);
            int offset = (currentPage - 1) * ShoppingController.ITEM_PER_PAGE;
            int totalItems = itemModel.getCountPage();
            int count = (int) Math.ceil((double) totalItems / ShoppingController.ITEM_PER_PAGE);
            List<Item> itemPerPage = itemModel.getItemPerPage(offset, ShoppingController.ITEM_PER_PAGE);
            model.addAttribute("totalPages", count);
            model.addAttribute("ItemInfo", itemPerPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/admin_manager_shopping";
    }

}
