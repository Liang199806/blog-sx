package com.niit.soft.factory;

import com.niit.soft.service.UserService;
import com.niit.soft.service.impl.UserServiceImpl;

/**
 * @author Liang
 * @ClassName ServiceFactory
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }
}
