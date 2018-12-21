/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import com.starter.bean.Customer;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author pc
 */
@Controller
public class HomeController {

    @RequestMapping("/index.htm")
    public String index() {
        return "index";
    }
    @RequestMapping("/logout.htm")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("LoginInfo");
        Cookie[] cookies = request.getCookies();
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("email") || cooky.getName().equals("password")) {
                cooky.setValue("");
                cooky.setMaxAge(0);
                response.addCookie(cooky);
            }
        }
        return "redirect:/login.htm";
    }

    @RequestMapping("/profile.htm")
    public String profile() {
        return "profile";
    }

    @RequestMapping("/home.htm")
    public String home(ModelMap model, HttpServletRequest resquest, HttpServletResponse reponse) {
        return "home";
    }

}
