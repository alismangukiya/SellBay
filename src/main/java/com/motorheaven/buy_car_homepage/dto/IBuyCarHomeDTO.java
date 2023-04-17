package com.motorheaven.buy_car_homepage.dto;

import com.motorheaven.buy_car_homepage.model.BuyCarHomepageModel;
import java.sql.ResultSet;
import java.util.List;

public interface IBuyCarHomeDTO {
    List<BuyCarHomepageModel> getCars();
    List<BuyCarHomepageModel> resultToObject(ResultSet result);
}
