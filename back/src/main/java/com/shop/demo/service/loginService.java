package com.shop.demo.service;

import com.shop.demo.entity.User;
import org.springframework.stereotype.Service;

public interface loginService {
    int addNewUser(User newUser);
}
