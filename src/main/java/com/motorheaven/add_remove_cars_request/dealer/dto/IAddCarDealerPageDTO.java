package com.motorheaven.add_remove_cars_request.dealer.dto;

import java.sql.ResultSet;
import java.util.List;

import com.motorheaven.add_remove_cars_request.dealer.model.GetNewCarDataModel;

public interface IAddCarDealerPageDTO {
    public ResultSet getdealerCar();
    public List<GetNewCarDataModel> getDealerCars(String email);
	public void removeDealerCar(String id);
	public void addDealerCar(String string, GetNewCarDataModel carModel);
}
