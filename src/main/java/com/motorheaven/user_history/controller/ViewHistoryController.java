package com.motorheaven.user_history.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.motorheaven.user_history.dto.IViewHistoryDTO;
import com.motorheaven.user_history.dto.ViewHistoryDTO; 

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewHistoryController {
    IViewHistoryDTO viewHistory = new ViewHistoryDTO();
    
    @GetMapping("/viewHistory")
    public String viewHistory(Model model, HttpServletRequest request){
        List<?> emails = (List<?>) request.getSession().getAttribute("userid");
        String email = (String)emails.get(0);
        model.addAttribute("appointment",viewHistory.getAppointment(email));
        model.addAttribute("reservation", viewHistory.getReservation(email));
        return "viewHistory.html";
    }
}
