package com.motorheaven.rent_car_homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.motorheaven.rent_car_homepage.model.RentCarHomepageModel;;

@Controller
public class RentCarHomepageController {

    @GetMapping("/rentcarhome")
    public String getHomepage(Model model, HttpServletRequest request) {
        RentCarHomepageModel renthome = new RentCarHomepageModel();
		model.addAttribute("renthome", renthome.getRentHomepageCars());
        if(request.getSession().getAttribute("userid") == null){
            model.addAttribute("logsession", "deactivate");
            model.addAttribute("insession", "activate");
        }else{
            model.addAttribute("logsession", "activate");
            model.addAttribute("insession", "deactivate");
        }
		return "renthomepage.html";
	}
}
