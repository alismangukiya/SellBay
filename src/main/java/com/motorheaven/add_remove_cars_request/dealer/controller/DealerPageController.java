package com.motorheaven.add_remove_cars_request.dealer.controller;
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
import com.motorheaven.add_remove_cars_request.dealer.dto.AddCarDealerPageDTO;
import com.motorheaven.add_remove_cars_request.dealer.dto.IAddCarDealerPageDTO;
import com.motorheaven.add_remove_cars_request.dealer.model.GetNewCarDataModel;

@Controller
public class DealerPageController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	IAddCarDealerPageDTO newcarDto = context.getBean("dealerPageDtoObject",AddCarDealerPageDTO.class);
	GetNewCarDataModel carModel = new GetNewCarDataModel();

	@GetMapping("/addcardealer")
	public String redirectDealerConfigPage(Model model,HttpServletRequest request) throws SQLException {
		model.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("dealerid")).get(0)));
		return "addcardealer.html";
	}
	
	@PostMapping("/addcardealer")
	public String addNewCar(HttpServletRequest request,@RequestParam("model") String model, @RequestParam("company")String company, @RequestParam("price")Integer price, @RequestParam("fuelType") String fuelType,@RequestParam("mileage") String mileage,@RequestParam("transmission") String transmission,@RequestParam("status") String status,@RequestParam("imgUrl") String imgUrl, Model datamodel) 
	{
		carModel.setCompany(company);
		carModel.setFuelType(fuelType);
		carModel.setImageUrl(imgUrl);
		carModel.setMileage(mileage);
		carModel.setModel(model);
		carModel.setPrice(price);
		carModel.setTransmission(transmission);
		carModel.setStatus(status);
		newcarDto.addDealerCar(((List<String>) request.getSession().getAttribute("dealerid")).get(0),carModel);
		datamodel.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("dealerid")).get(0)));
		return "addcardealer.html";
	}

	@GetMapping("/addcardealer/{id}")
    public String viewCarPage(HttpServletRequest request,@PathVariable String id, Model model) {
        newcarDto.removeDealerCar(id);
		model.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("dealerid")).get(0)));
        return "addcardealer.html";
    }
	
	public String viewDealerCar(HttpServletRequest request,ModelMap modelmap,Model model) {
		ResultSet s1 = newcarDto.getdealerCar();
		try {
			System.out.println(s1.getString("model"));
			model.addAttribute("model2", carModel.getHomepageCars(((List<String>) request.getSession().getAttribute("dealerid")).get(0)));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "addcardealer.html";
	}
}
