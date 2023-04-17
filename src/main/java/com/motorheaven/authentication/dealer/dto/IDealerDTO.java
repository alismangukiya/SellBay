package com.motorheaven.authentication.dealer.dto;

import com.motorheaven.authentication.dealer.model.DealerModel;
import com.motorheaven.authentication.mainmodel.IUserModel;

public interface IDealerDTO {
    public Boolean registerDealer(IUserModel newDealer);
    public Boolean loginAuthDealer(IUserModel authUser);
}
