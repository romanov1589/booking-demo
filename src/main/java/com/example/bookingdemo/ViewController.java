package com.example.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.text.View;
import java.util.Date;

/**
 * View Controller that open our index page
 */
@Controller
public class ViewController {

    private String appMode;

    @Autowired
    public ViewController(Environment environment){
        this.appMode = environment.getProperty("app-mode");
    }
    /**
     * GET an index page
     * @param model add attributes for our index page
     * @return an index page
     */
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Igor Romanov");
        model.addAttribute("mode", appMode);
        return "index";
    }
}
