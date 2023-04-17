package com.motorheaven.authentication.renter.dto;

import com.motorheaven.authentication.mainmodel.IUserModel;

public interface IRentalDTO {
    public Boolean registerRental(IUserModel newRental);
    public Boolean loginAuthRental(IUserModel authRental);
}
