package com.motorheaven.rent_car_request.controller;

import com.motorheaven.rent_car_request.dto.IRentCarDTO;
import com.motorheaven.rent_car_request.dto.RentCarDTO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RentCarController {

    IRentCarDTO carService = new RentCarDTO();

    @GetMapping("/viewRentCar/{id}")
    public String viewCarPage(@PathVariable String id, Model model, HttpServletRequest request) {
        model.addAttribute("Car",carService.getCarById(Integer.parseInt(id)));
        model.addAttribute("Car",carService.getCarById(Integer.parseInt(id)));
        if(request.getSession().getAttribute("userid") == null){
            model.addAttribute("logsession", "deactivate");
            model.addAttribute("insession", "activate");
        }else{
            model.addAttribute("logsession", "activate");
            model.addAttribute("insession", "deactivate");
        }
        return "viewrentcar.html";
    }
    
}
