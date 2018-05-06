package com.dboard.services.service;

import com.dboard.services.dao.LoginDao;
import com.dboard.services.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public boolean authenticateUser(LoginEntity loginEntity){

        boolean isValidUser = false;
        LoginEntity response = loginDao.findByUserNameEqualsAndPasswordEquals(loginEntity.getUserName(), loginEntity.getPassword());

        if(response != null){
            isValidUser = true;
        }
        return isValidUser;
    }
}
