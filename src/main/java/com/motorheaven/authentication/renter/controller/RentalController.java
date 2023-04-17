package com.motorheaven.authentication.renter.controller;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motorheaven.add_remove_cars_request.rental.dto.AddCarRentalPageDTO;
import com.motorheaven.add_remove_cars_request.rental.model.GetRentCarDataModel;
import com.motorheaven.authentication.renter.dto.RentalDTO;
import com.motorheaven.authentication.mainmodel.IUserModel;
import com.motorheaven.authentication.renter.dto.IRentalDTO;

import com.motorheaven.authentication.renter.model.RentalModel;
import com.motorheaven.utility.IUserFactory;
import com.motorheaven.utility.UserFactory;

@Controller
public class RentalController {

	IUserFactory userFactory = new UserFactory();
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	IRentalDTO rentaldto = context.getBean("rentalDtoObject",RentalDTO.class);
	AddCarRentalPageDTO rentDto = context.getBean("rentalPageDtoObject",AddCarRentalPageDTO.class);
	@GetMapping("/registerrent")
	public String getRegisterPage(Model model) {
		return "rentalregister.html";
	}

	@GetMapping("/rentallogin")
	public String getLoginPage(Model model) {
		return "loginrental.html";
	}

	@PostMapping("/registerrental")
	public String registerUser(@RequestParam("email") String email, @RequestParam("password")String password, @RequestParam("password1")String password1, @RequestParam("phoneNum") String phoneNum, Model model,HttpServletRequest request,GetRentCarDataModel carDTO) {
		IUserModel newRental = userFactory.getRenterModel();
		newRental.setEmail(email);
		newRental.setPassword(password);
		newRental.setPassword1(password1);
		newRental.setphoneNum(phoneNum);
		Boolean user = rentaldto.registerRental(newRental);
		
		if(user) {
			List<String> rentalList = (List<String>) request.getSession().getAttribute("rentalid");
				if(rentalList==null) {
					rentalList = new ArrayList<>();
					request.getSession().setAttribute("rentalid", rentalList);
				}
				rentalList.add(email);
				request.getSession().setAttribute("rentalid", rentalList);
				String rentalEmail = ((List<String>) request.getSession().getAttribute("rentalid")).get(0);
			model.addAttribute("model", carDTO.getHomepageCars(rentalEmail));
			model.addAttribute("rentalEmail", rentalEmail);
			return "rentaldashboard.html";  
		}
		else {
			String message = "Unable to register please try again";
			model.addAttribute("message", message);
			return "rentalregister.html";
		}
		
	}

	@PostMapping("/loginUserrental")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,Model model,HttpServletRequest request,GetRentCarDataModel carDTO) {
		IUserModel authRental = userFactory.getRenterModel();
		authRental.setEmail(email);
		authRental.setPassword(password);
		try {
			ResultSet rs = rentDto.getrentalCar();
		} catch (Exception e) {
			System.out.println(e);
		}
		Boolean user =  rentaldto.loginAuthRental(authRental);
			if(user) {
				List<String> rentalList = (List<String>) request.getSession().getAttribute("rentalid");
					if(rentalList==null) {
						rentalList = new ArrayList<>();
						request.getSession().setAttribute("rentalid", rentalList);
					}
					rentalList.add(email);
					request.getSession().setAttribute("rentalid", rentalList); 
					String rentalEmail = ((List<String>) request.getSession().getAttribute("rentalid")).get(0);
				model.addAttribute("model", carDTO.getHomepageCars(rentalEmail));
				model.addAttribute("rentalEmail", rentalEmail);
				return "rentaldashboard.html";
			}
			else {   
				String message = "Unable to login";
				model.addAttribute("message",message);
				return "loginrental.html";
			}   
	}
}
