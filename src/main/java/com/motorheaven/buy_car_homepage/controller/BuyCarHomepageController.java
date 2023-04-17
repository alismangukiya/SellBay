package com.motorheaven.buy_car_homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.motorheaven.buy_car_homepage.model.BuyCarHomepageModel;

@Controller
public class BuyCarHomepageController {

    @GetMapping("/")
    public String getHomepage(Model model, HttpServletRequest request) {
        BuyCarHomepageModel buycar = new BuyCarHomepageModel();
		model.addAttribute("buycar", buycar.getHomepageCars());
        if(request.getSession().getAttribute("userid") == null){
            model.addAttribute("logsession", "deactivate");
            model.addAttribute("insession", "activate");
        }else{
            model.addAttribute("logsession", "activate");
            model.addAttribute("insession", "deactivate");
        }
		return "index.html";
	}
}
