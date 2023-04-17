package com.motorheaven.authentication.user.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motorheaven.authentication.mainmodel.IUserModel;
import com.motorheaven.authentication.user.dto.*;
import com.motorheaven.buy_car_homepage.model.BuyCarHomepageModel;
import com.motorheaven.utility.IUserFactory;
import com.motorheaven.utility.UserFactory;;


@Controller
public class UserController {
	
IUserFactory userFactory = new UserFactory();
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	IUserDTO userdto = context.getBean("userDtoObject",UserDTO.class);
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		return "register.html";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		return "login.html";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestParam("email") String email, @RequestParam("password")String password, @RequestParam("password1")String password1, @RequestParam("phoneNum") String phoneNum, Model model, HttpServletRequest request) {
		IUserModel newUser = userFactory.getUserModel();
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setPassword1(password1);
		newUser.setphoneNum(phoneNum);
		   Boolean user = userdto.registerUser(newUser);
		   	if(user) {
			  List<String> usersList = (List<String>) request.getSession().getAttribute("userid");
				if(usersList==null) {
					usersList = new ArrayList<>();
					request.getSession().setAttribute("userid", usersList);
				}
				usersList.add(email);
				request.getSession().setAttribute("userid", usersList);
				System.out.println(usersList);
			   	return "redirect:/";   
		   	}
		   	else {
			   String message = "Unable to register please use different Email or password";
			   model.addAttribute("message", message);
			   return "register.html";
		   	}
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest request) {
		IUserModel authUser = userFactory.getUserModel();
		authUser.setEmail(email);
		authUser.setPassword(password);
		Boolean boolUser =  userdto.loginAuthUser(authUser);
			   if(boolUser) {
				   List<String> usersList = (List<String>) request.getSession().getAttribute("userid");
					if(usersList==null) {
						usersList = new ArrayList<>();
						request.getSession().setAttribute("userid", usersList);
					}
					usersList.add(email);
					request.getSession().setAttribute("userid", usersList);
					System.out.println(usersList);
				return "redirect:/";
				}
			   	else {
				   String message = "Unable to login";
				   model.addAttribute("message", message);
				   return "login.html";
			   	}
	}
	
	@GetMapping("/logoutUser")
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
        return "redirect:/";
	}
}
