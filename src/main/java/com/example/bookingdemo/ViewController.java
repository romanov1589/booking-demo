package com.example.bookingdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * View Controller that open our index page
 */
@Controller
public class ViewController {
    /**
     * GET an index page
     * @param model add attributes for our index page
     * @return an index page
     */
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Igor Romanov");
        model.addAttribute("mode", "development");
        return "index";
    }
}
