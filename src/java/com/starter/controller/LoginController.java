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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author chellong
 */

@Controller
@SessionAttributes("LoginInfo")
public class LoginController {
    private Customer customer = null;
    @RequestMapping(value = "redirectLogin.htm", method = {RequestMethod.POST, RequestMethod.GET})
    public String redirectLogin(@ModelAttribute("register") STATUS result, ModelMap model) {
        System.out.println("=======Result=======" + " " + result);
        model.addAttribute("resultRegister", result);
        return "login";
    }
    
    @RequestMapping(value = "login.htm")
    public String login (HttpServletRequest request, ModelMap model) throws Exception {
        HttpSession session = request.getSession(false);
        String email = "";
        String password = "";
//        System.out.println("====session " + session.getAttribute("LoginInfo"));
        Cookie[] cookies = request.getCookies();
        System.out.println("suctomer " + this.customer);
        boolean check = false;
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                System.out.println("Cookie " + cooky.getName() + " " + cooky.getValue());
                if (cooky.getName().equals("email")) {
                    email = cooky.getValue();
                    check = true;
                } else if (cooky.getName().equals("password")) {
                    password = cooky.getValue();
                }
            }
        }
        System.out.println("session " + session);
        if(check && session==null ) {
            Customer cus = CustomerModel.login(email, password);
            System.out.println("cus " + cus);
            model.addAttribute("LoginInfo", cus);
        }
        return "login";
    }
    
    @RequestMapping(value = "handleLogin.htm")
    public String handleLogin(ModelMap model, @RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        String checkbox = request.getParameter("remember-me");
        System.out.println("===========================");
        System.out.println("email " + email + " " +password + " " + checkbox);
        try {
            Customer cus = CustomerModel.login(email, password);
            this.customer = (Customer)cus.clone();
            System.out.println("cus " + cus);
            if(cus!=null) {
                model.addAttribute("LoginInfo", cus);
                if(checkbox!=null) {
                    Cookie userCookie = new Cookie("email",email);
                    userCookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(userCookie);
                    Cookie passCookie = new Cookie("password", password);
                    passCookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(passCookie);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/index.htm";
    }
    
    @RequestMapping(value = "adminLogin")
    public String adminLogin () {
        return "admin/login";
    }
}
