/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import com.starter.bean.Customer;
import com.starter.model.CustomerModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author chellong
 */
 enum STATUS {
   SUCCESS, FAILURE
}
@Controller
public class RegisterController {
    CustomerModel customerModel = null;
    /**
     * @TODO:
     */
    @RequestMapping("/register.htm")
    public String register() {
        try {
            customerModel = CustomerModel.getInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "register";
    }

    @RequestMapping("/handleRegister.htm")
    public String handleRegister(ModelMap model,
            RedirectAttributes ra,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("checkbox-signup") String checkbox) {
        try {
            System.out.println("============================");
            System.out.println("name " + name + "email " + email + "password " + password + "checkbox " + checkbox);
            Customer cus = new Customer.CustomerBuilder(email, password, name).build();
            customerModel.add(cus);
        } catch (Exception ex) {
            ra.addFlashAttribute("register", STATUS.FAILURE);
            ex.printStackTrace();
        }
        ra.addFlashAttribute("register", STATUS.SUCCESS);
        return "redirect:/redirectLogin.htm";

    }
}
