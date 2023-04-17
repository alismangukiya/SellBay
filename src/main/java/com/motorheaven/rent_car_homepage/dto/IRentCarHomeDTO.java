package com.motorheaven.rent_car_homepage.dto;
import java.sql.ResultSet;
import java.util.List;
import com.motorheaven.rent_car_homepage.model.RentCarHomepageModel;

public interface IRentCarHomeDTO {
    List<RentCarHomepageModel> getCars();
    List<RentCarHomepageModel> resultToObject(ResultSet queryResult);
}
