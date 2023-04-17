package com.motorheaven.authentication.dealer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motorheaven.authentication.dealer.model.DealerModel;
import com.motorheaven.authentication.mainmodel.IUserModel;
import com.motorheaven.utility.IUserFactory;
import com.motorheaven.utility.UserFactory;
import com.motorheaven.add_remove_cars_request.dealer.model.GetNewCarDataModel;
import com.motorheaven.authentication.dealer.dto.DealerDTO;
import com.motorheaven.authentication.dealer.dto.IDealerDTO;

@Controller
public class DealerController {


	IUserFactory userFactory = new UserFactory();
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	IDealerDTO dealerservice=context.getBean("dealerDtoObject",DealerDTO.class);

	public void setDealerservice(DealerDTO dealerservice) {
		this.dealerservice = dealerservice;
	}

	@GetMapping("/registerdealer")
	public String getRegisterPage(Model model) {
		return "dealerregister.html";
	}

	@GetMapping("/dealerlogin")
	public String getLoginPage(Model model) {
		model.addAttribute("loginRequest", new DealerModel());
		return "logindealer.html";
	}

	@PostMapping("/registerdealer")
	public String registerDealer(@RequestParam("email") String email, @RequestParam("password")String password, @RequestParam("password1")String password1, @RequestParam("phoneNum") String phoneNum, Model model,HttpServletRequest request,GetNewCarDataModel carDTO) {
		IUserModel newUser = userFactory.getDeleaModel();
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setPassword1(password1);
		newUser.setphoneNum(phoneNum);
		Boolean user = dealerservice.registerDealer(newUser);
		if(user) {
			List<String> dealersList = (List<String>) request.getSession().getAttribute("dealerid");
			if(dealersList==null) {
				dealersList = new ArrayList<>();
				request.getSession().setAttribute("dealerid", dealersList);
			}
			dealersList.add(email);
			request.getSession().setAttribute("dealerid", dealersList);
			String dealerEmail = ((List<String>) request.getSession().getAttribute("dealerid")).get(0);
			model.addAttribute("model", carDTO.getHomepageCars(dealerEmail));
			model.addAttribute("dealerEmail", dealerEmail);
			return "dealerdashboard.html";  
		}
		else{
			String message = "Unable to Register Try again";
			model.addAttribute("message", message);
			return "dealerregister.html";
		}
	}

	@PostMapping("/loginUserdealer")
	public String loginDealer(@RequestParam("email") String email, @RequestParam("password") String password, Model model,HttpServletRequest request,GetNewCarDataModel carDTO) {
		IUserModel authUser = userFactory.getDeleaModel();
		authUser.setEmail(email);
		authUser.setPassword(password);
		Boolean boolUser =  dealerservice.loginAuthDealer(authUser);
				if(boolUser) {
					List<String> dealersList = (List<String>) request.getSession().getAttribute("dealerid");
					if(dealersList==null) {
						dealersList = new ArrayList<>();
						request.getSession().setAttribute("dealerid", dealersList);
					}
					dealersList.add(email);
					request.getSession().setAttribute("dealerid", dealersList);
					
					String dealerEmail = ((List<String>) request.getSession().getAttribute("dealerid")).get(0);
					model.addAttribute("model", carDTO.getHomepageCars(dealerEmail));
					model.addAttribute("dealerEmail", dealerEmail);
					return "dealerdashboard.html";
				}
				else {
					String message = "Unable to login";
					model.addAttribute("message", message);
					return "logindealer.html";
				}   
		
	}
}
