/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import com.starter.bean.Item;
import com.starter.bean.Product;
import com.starter.bean.Store;
import com.starter.model.ItemModel;
import com.starter.model.ProductModel;
import com.starter.model.StoreModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author chellong
 */
@Controller
@SessionAttributes({"StoreInfo", "ItemInfo", "typeStore"})
public class ShoppingController {

    public static final int ITEM_PER_PAGE = 15;
    private StoreModel storeModel;
    private ItemModel itemModel;
    private ProductModel productModel;
    private List<Integer> prices;

    @RequestMapping(value = "shopping.htm", method = {RequestMethod.POST, RequestMethod.GET})
    public String shopping(ModelMap model, HttpServletRequest request, HttpSession session) {
        try {
            storeModel = StoreModel.getInstance();
            itemModel = ItemModel.getInstance();
            productModel = ProductModel.getInstance();
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
                        int totalItems = -1;
                        List<Item> itemPerPage = null;
                        String typeStore = request.getParameter("typeStore");
                        String product = request.getParameter("product");
                        String price = request.getParameter("price");
                        String min = request.getParameter("min");
                        String max = request.getParameter("max");
                        System.out.println("=======PARAM=======" + typeStore);
                        if (typeStore != null) {
                            List<Product> list = productModel.selectProductByTypeStore(typeStore);
                            model.addAttribute("typeProducts", list);
                            model.addAttribute("typeStore", typeStore);
                            switch (typeStore) {
                                case Store.Type.ITSHIRT:
                                    if (product != null) {
                                        if (price != null) {
                                            String[] strs = price.split("[-]");
                                            itemPerPage = itemModel.getItemByTypeProductAndPrice(product, Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), offset, ShoppingController.ITEM_PER_PAGE);
                                            totalItems = itemModel.getCountItemByTypeProductAndPrice(product, Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
                                            model.addAttribute("selectedProduct", product);
                                            model.addAttribute("selectedPrice", Integer.parseInt(strs[0]));
                                        } else if (min != null && max != null) {
                                            itemPerPage = itemModel.getItemByPrice(Integer.parseInt(min), Integer.parseInt(max), offset, ShoppingController.ITEM_PER_PAGE);
                                            totalItems = itemModel.getCountItemByPrice(Integer.parseInt(min), Integer.parseInt(max));
                                        } else {
                                            System.out.println("product " + product);
                                            itemPerPage = itemModel.getItemByTypeProduct(product, offset, ShoppingController.ITEM_PER_PAGE);
                                            totalItems = itemModel.getCountInProduct(product);
                                            model.addAttribute("selectedProduct", product);
                                            break;
                                        }
                                    } else if (price != null) {
                                        String[] strs = price.split("[-]");
                                        itemPerPage = itemModel.getAllItemInStoreByPrice(typeStore, Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), offset, ShoppingController.ITEM_PER_PAGE);
                                        totalItems = itemModel.getCountItemInStoreByPrice(typeStore, Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
                                        model.addAttribute("selectedPrice", Integer.parseInt(strs[0]));
                                    } else if (min != null && max != null) {
                                        itemPerPage = itemModel.getItemByPrice(Integer.parseInt(min), Integer.parseInt(max), offset, ShoppingController.ITEM_PER_PAGE);
                                        totalItems = itemModel.getCountItemByPrice(Integer.parseInt(min), Integer.parseInt(max));
                                    } else {
                                        itemPerPage = itemModel.getAllItemInStore(Store.Type.ITSHIRT, offset, ShoppingController.ITEM_PER_PAGE);
                                        totalItems = itemModel.getCountInStore(typeStore);
                                    }
                                    break;
                                default:
                            }
                        }
                        if (itemPerPage == null) {
                            if (price != null) {
                                String[] strs = price.split("[-]");
                                System.out.println("str " + strs[0]);
                                itemPerPage = itemModel.getItemByPrice(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), offset, ShoppingController.ITEM_PER_PAGE);
                                totalItems = itemModel.getCountItemByPrice(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
                                model.addAttribute("selectedPrice", Integer.parseInt(strs[0]));
                            } else if (min != null && max != null) {
                                itemPerPage = itemModel.getItemByPrice(Integer.parseInt(min), Integer.parseInt(max), offset, ShoppingController.ITEM_PER_PAGE);
                                totalItems = itemModel.getCountItemByPrice(Integer.parseInt(min), Integer.parseInt(max));
                            } else {
                                itemPerPage = itemModel.getItemPerPage(offset, ShoppingController.ITEM_PER_PAGE);
                            }
                        }
                        if (totalItems == -1) {
                            totalItems = itemModel.getCountPage();
                        }
                        model.addAttribute("totalItems", totalItems);

                        int count = (int) Math.ceil((double) totalItems / ShoppingController.ITEM_PER_PAGE);
                        model.addAttribute("totalPages", count);

                        model.addAttribute("ItemInfo", itemPerPage);

                        model.addAttribute("prices", ItemModel.prices);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            Thread t3 = new Thread(() -> {
                try {
//                    List<Product> list = productModel.getAll();
//                    for (Product product : list) {
//                        System.out.println("product " + product);
//                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "shopping";
    }

    @RequestMapping(value = "selectStore.htm")
    public String handleSelectStore(@RequestParam(value = "typeStore") String typeStore, ModelMap model, RedirectAttributes ra) {
        try {
            System.out.println("typeStore " + typeStore);
            switch (typeStore) {
                case Store.Type.ITSHIRT:
                    //handle select by type store
//                    List<Product> list = productModel.selectProductByTypeStore(type);
//                    for (Product product : list) {
//                        System.out.println("product " + product);
//                    }
//                    model.addAttribute("typeProducts", list);
                    break;

                case Store.Type.ACCESSORY:
                    break;
                case Store.Type.MACBOOK:
                    break;
                case Store.Type.SMARTPHONE:
                    break;
                case Store.Type.WATCH:
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/shopping.htm?typeStore=" + typeStore;
    }

    @RequestMapping(value = "filter-by-type-product.htm")
    public String filterByTypeProduct(ServletRequest request, HttpSession session) {
        String typeProduct = request.getParameter("type-product");
        String typeStore = (String) session.getAttribute("typeStore");
        String price = request.getParameter("price");
        System.out.println("price " + price + "type product " + typeProduct);
        if (!typeProduct.equals("") && !price.equals("")) {
            System.out.println("1");
            return "redirect:/shopping.htm?product=" + typeProduct + "&price=" + price;
        } else if (price.equals("")) {
            System.out.println("2");
            return "redirect:/shopping.htm?product=" + typeProduct;
        }
        System.out.println("3");
        return "redirect:/shopping.htm?price=" + price;
    }
}
