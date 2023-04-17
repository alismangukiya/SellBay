package com.motorheaven.authentication.user.dto;

import com.motorheaven.authentication.mainmodel.*;

public interface IUserDTO {
    public Boolean registerUser(IUserModel newUser);
    public Boolean loginAuthUser(IUserModel authUser);
}
