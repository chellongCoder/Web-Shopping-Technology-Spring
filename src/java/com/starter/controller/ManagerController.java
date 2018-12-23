/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import com.starter.bean.Customer;
import com.starter.bean.Item;
import com.starter.bean.Product;
import com.starter.bean.Store;
import com.starter.model.CustomerModel;
import com.starter.model.ItemModel;
import com.starter.model.ProductModel;
import com.starter.model.StoreModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author chellong
 */

@Controller
@SessionAttributes("choice")
@MultipartConfig(maxFileSize = 10*1024*1024,maxRequestSize = 20*1024*1024,fileSizeThreshold = 5*1024*1024)
public class ManagerController {
    private static final long SerialVersionUID = 1L;
    private static final String  UPLOAD_DIR = "images";
    public static final int ITEM_PER_PAGE = 10;
    private ItemModel itemModel;
    private ProductModel productModel;
    private StoreModel storeModel;
    private CustomerModel customerModel;

    private static int totalRows = 0;
    private static int totalPages = 0;
    private static int offset = 0;

    private static ArrayList<String> head = new ArrayList<String>();

    @RequestMapping(value = "manager.htm")
    
    public String manager( HttpServletRequest request, ModelMap model) {
        try {
            int currentPage = 1;
            itemModel = ItemModel.getInstance();
            productModel = ProductModel.getInstance();
            storeModel = StoreModel.getInstance();
            customerModel = CustomerModel.getInstance();
            
            if (request.getParameter("page") != null) {
                currentPage = Integer.parseInt(request.getParameter("page"));
            }
            model.addAttribute("currentPage", currentPage);
            ManagerController.offset = (currentPage - 1) * ManagerController.ITEM_PER_PAGE;

            if (!ManagerController.head.isEmpty()) {
                ManagerController.head.clear();
            }
            String choice = request.getParameter("choice");
            if (choice == null) {
                choice = "Item";
            }
//            else {
            switch (choice) {
                case "Customer":
                    model.addAttribute("choice", "Customer");
                    handleWithCustomer(customerModel, model);
                    break;
                case "Store":
                    model.addAttribute("choice", "Store");
                    handleWithStore(storeModel, model);
                    break;
                case "Product":
                    model.addAttribute("choice", "Product");
                    handleWithProduct(productModel, model);
                    break;
                case "Item":
                    model.addAttribute("choice", "Item");
                    handleWithItem(itemModel, model);
                    break;
                case "History":
                    break;
                default:
//                        handleWithItem(itemModel, model);
                    break;
            }
//            }
            model.addAttribute("totalPages", ManagerController.totalPages);
            model.addAttribute("head", ManagerController.head);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/admin_manager_shopping";
    }

    public void handleWithItem(ItemModel itemModel, ModelMap model) throws Exception {
        ManagerController.totalRows = itemModel.getCountPage();
        System.out.println("total row " + totalRows);
        ManagerController.totalPages = (int) Math.ceil((double) ManagerController.totalRows / ManagerController.ITEM_PER_PAGE);
        System.out.println("total page " + totalPages);
        List<Item> itemPerPage = itemModel.getItemPerPage(ManagerController.offset, ManagerController.ITEM_PER_PAGE);
        itemPerPage.forEach((item) -> {
            System.out.println("item " + item);
        });
        ManagerController.head.add("Id");
        ManagerController.head.add("name");
        ManagerController.head.add("price");
        ManagerController.head.add("status");
        ManagerController.head.add("note");
        ManagerController.head.forEach((item) -> {
            System.out.println("item " + item);
        });
        model.addAttribute("ItemInfo", itemPerPage);

    }

    public void handleWithProduct(ProductModel productModel, ModelMap model) throws Exception {
        ManagerController.totalRows = productModel.getCountPage();
        ManagerController.totalPages = (int) Math.ceil((double) ManagerController.totalRows / ManagerController.ITEM_PER_PAGE);
        List<Product> productPerPage = productModel.getProductPerPage(ManagerController.offset, ManagerController.ITEM_PER_PAGE);
        ManagerController.head.add("Id");
        ManagerController.head.add("name product");
        ManagerController.head.add("quantity");
        model.addAttribute("ItemInfo", productPerPage);
    }
    
    public void handleWithStore(StoreModel storeModel, ModelMap model) throws Exception {
        ManagerController.totalRows = storeModel.getCountPage();
        ManagerController.totalPages = (int) Math.ceil((double) ManagerController.totalRows / ManagerController.ITEM_PER_PAGE);
        List<Store> storePerPage = storeModel.getStorePerPage(ManagerController.offset, ManagerController.ITEM_PER_PAGE);
        ManagerController.head.add("Id");
        ManagerController.head.add("type");
        model.addAttribute("ItemInfo", storePerPage);
    }
    
    public void handleWithCustomer(CustomerModel customerModel, ModelMap model) throws Exception {
        ManagerController.totalRows = customerModel.getCountPage();
        ManagerController.totalPages = (int) Math.ceil((double) ManagerController.totalRows / ManagerController.ITEM_PER_PAGE);
        List<Customer> customerPerPage = customerModel.getCustomerPerPage(ManagerController.offset, ManagerController.ITEM_PER_PAGE);
        customerPerPage.forEach((item) -> {
            System.out.println("item " + item);
    });
        ManagerController.head.add("Id");
        ManagerController.head.add("username");
        ManagerController.head.add("email");
        ManagerController.head.add("name");
        ManagerController.head.add("address");
        ManagerController.head.add("city");
        ManagerController.head.add("country");
        ManagerController.head.add("post code");
        ManagerController.head.add("about");
        ManagerController.head.add("type customer");
        model.addAttribute("ItemInfo", customerPerPage);
    }

    @RequestMapping(value = "addNew.htm")
    public String addNew(ModelMap model, RedirectAttributes ra, HttpSession session) {
        model.addAttribute("new", 1);
        ra.addFlashAttribute("new", 1);
        return "redirect:/manager.htm?choice="+session.getAttribute("choice");
    }
    
    @RequestMapping(value = "submitAddNew.htm")
    public String submitAddNew (@RequestParam("file") MultipartFile file,HttpSession session, HttpServletRequest request) {
        String fileName="";
        try {
            System.out.println("name file " + file.getName());
//            Part filePart = request.getPart("photo");
//            System.out.println("file part" + filePart);
//            fileName = (String) getFileName(filePart);
//            System.out.println("file name " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/manager.htm";
    }
    
     private String  getFileName(Part part){
        final String  partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :"+ partHeader);
        for(String content : part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")){
                return content.substring(content.indexOf('=')+1).trim().replace("\"", "" );
            }
        }
        
        return null;
    }

}
