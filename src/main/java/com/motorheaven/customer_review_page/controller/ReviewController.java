package com.motorheaven.customer_review_page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motorheaven.customer_review_page.dto.*;

@Controller
public class ReviewController {
    IReviewDTO review = new ReviewDTO();

    @GetMapping("/viewNewCar/{id}/reviews")
    public String viewBuyReviewPageString(@PathVariable String id, Model model) {
        model.addAttribute("review", review.getReviews(id));
        model.addAttribute("avgRating", review.getAverageRating(id));
        return "reviews.html";
    }

    @GetMapping("/viewRentCar/{id}/reviews")
    public String viewRentReviewPageString(@PathVariable String id, Model model) {
        model.addAttribute("review", review.getReviews(id));
        model.addAttribute("avgRating", review.getAverageRating(id));
        return "reviews.html";
    }

    @PostMapping("/viewNewCar/{id}/reviews")
    public String postBuyReviewPageString(@PathVariable String id, @RequestParam("name") String name, @RequestParam("rating") String rating, @RequestParam("review") String review,String password, Model model) {
        ReviewDTO reviews = new ReviewDTO();
        String url = "/viewNewCar/" +  id + "/reviews";
        reviews.storeNewReview(name, Integer.parseInt(rating), review, Integer.parseInt(id));
        model.addAttribute("review", reviews.getReviews(id));
        model.addAttribute("avgRating", reviews.getAverageRating(id));
        model.addAttribute("url", url);
        return "reviews.html";
    }

    @PostMapping("/viewRentCar/{id}/reviews")
    public String postRentReviewPageString(@PathVariable String id, @RequestParam("name") String name, @RequestParam("rating") String rating, @RequestParam("review") String review,Model model) {
        ReviewDTO reviews = new ReviewDTO();
        reviews.storeNewReview(name, Integer.parseInt(rating), review, Integer.parseInt(id));
        String url = "/viewRentCar/" +  id + "/reviews";
        model.addAttribute("review", reviews.getReviews(id));
        model.addAttribute("avgRating", reviews.getAverageRating(id));
        model.addAttribute("url", url);
        return "reviews.html";
    }

}
