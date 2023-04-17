package com.motorheaven.buy_car_request.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.motorheaven.buy_car_request.dto.INewCarDTO;
import com.motorheaven.buy_car_request.dto.NewCarDTO;

@Controller
public class NewCarController {

    INewCarDTO carService = new NewCarDTO();

    @GetMapping("/viewNewCar/{id}")
    public String viewCarPage(@PathVariable String id, Model model,HttpServletRequest request) {
        model.addAttribute("Car",carService.getCarById(Integer.parseInt(id)));
        if(request.getSession().getAttribute("userid") == null){
            model.addAttribute("logsession", "deactivate");
            model.addAttribute("insession", "activate");
        }else{
            model.addAttribute("logsession", "activate");
            model.addAttribute("insession", "deactivate");
        }
        return "viewCar.html";
    }
}
