package com.motorheaven.utility;

import com.motorheaven.authentication.dealer.model.DealerModel;
import com.motorheaven.authentication.mainmodel.IUserModel;
import com.motorheaven.authentication.renter.model.RentalModel;
import com.motorheaven.authentication.user.model.User;

public class UserFactory implements IUserFactory {

    
    @Override
    public IUserModel getUserModel() {
        return new User();
    }

    @Override
    public IUserModel getRenterModel() {
        return new RentalModel();
    }

    @Override
    public IUserModel getDeleaModel() {
        return new DealerModel();
    }
    
}
