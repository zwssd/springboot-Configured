package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class TestController{
    @RequestMapping("/test")
    public String testDemo(){
        return "aaaaaaa";
    }

    /**
     *创建表单
     * @author qqg
     * @date
     * @param  * @param model
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView indexDemo(Model model) {
        model.addAttribute("title", "aaaaabbbbbaaaaaaa");
        return new ModelAndView("index", "aa",model);
    }
}