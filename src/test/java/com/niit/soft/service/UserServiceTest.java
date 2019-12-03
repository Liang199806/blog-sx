package com.niit.soft.service;

import com.niit.soft.domain.dto.UserDto;
import com.niit.soft.factory.ServiceFactory;
import com.niit.soft.util.Result;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn() {
        UserDto userDao = new UserDto();
        userDao.setMobile("13921557438");
        userDao.setPassword("111");
        Result result = userService.signIn(userDao);
        System.out.println("code:"+result.getCode()+","+"msg"+result.getMsg());
    }
    @Test
    public void getHotUsers() {
        Result result = userService.getHotUsers();
        System.out.println(result);
    }
}