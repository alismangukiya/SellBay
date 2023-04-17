package com.motorheaven.add_remove_cars_request.rental.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motorheaven.add_remove_cars_request.rental.dto.AddCarRentalPageDTO;
import com.motorheaven.add_remove_cars_request.rental.dto.IAddCarRentalPageDTO;
import com.motorheaven.add_remove_cars_request.rental.model.GetRentCarDataModel;
import com.motorheaven.authentication.dealer.dto.DealerDTO;

@Controller
public class RentalPageController {

	//removed Dependecies using Bean Factory and Inversion of Control Principle
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	IAddCarRentalPageDTO rentalPageDto = context.getBean("rentalPageDtoObject",AddCarRentalPageDTO.class);
	GetRentCarDataModel carModel = new GetRentCarDataModel();

	@GetMapping("/addcarrental")
	public String redirectRentalConfigPage(HttpServletRequest request,Model model) throws SQLException {
		model.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("rentalid")).get(0)));
		return "addcarrental.html";
	}
	
	@PostMapping("/addcarrental")
	public String addRentCar(HttpServletRequest request,@RequestParam("model") String model, @RequestParam("company")String company, @RequestParam("price")Integer price, @RequestParam("fuelType") String fuelType,@RequestParam("mileage") String mileage,@RequestParam("transmission") String transmission,@RequestParam("condition") String condition,@RequestParam("status") String status,@RequestParam("imgUrl") String imgUrl, Model datamodel) {
		carModel.setCompany(company);
		carModel.setConditions(condition);
		carModel.setFuelType(fuelType);
		carModel.setImageUrl(imgUrl);
		carModel.setMileage(mileage);
		carModel.setModel(model);
		carModel.setPrice(price);
		carModel.setTransmission(transmission);
		carModel.setStatus(status);
		rentalPageDto.addRentalCar(((List<String>) request.getSession().getAttribute("rentalid")).get(0),carModel);
		datamodel.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("rentalid")).get(0)));
		return "addcarrental.html";
	}
	
	public String viewRentalCar(HttpServletRequest request,ModelMap modelmap,Model model) {
		ResultSet s1=null;
		try {
			s1 = rentalPageDto.getrentalCar();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		try {
			System.out.println(s1.getString("model"));
			model.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("rentalid")).get(0)));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "addcarrental.html";
	}

	@GetMapping("/addcarrental/{id}")
    public String viewCarPage(HttpServletRequest request,@PathVariable String id, Model model) {
        rentalPageDto.removeCar(id);
		model.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("rentalid")).get(0)));
        return "addcarrental.html";
    }
}
