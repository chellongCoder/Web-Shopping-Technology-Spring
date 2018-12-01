/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "login.htm", method = { RequestMethod.POST, RequestMethod.GET })
    public String login(@ModelAttribute("register") String result) {
        System.out.println("=======Result======="  + " " + result);
        return "login";
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
