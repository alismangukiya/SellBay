package com.motorheaven.utility;
import com.motorheaven.authentication.mainmodel.*;

public interface IUserFactory {
    public IUserModel getUserModel();
    public IUserModel getRenterModel();
    public IUserModel getDeleaModel();
}
