package com.niit.soft.factory;

import com.niit.soft.dao.UserDao;
import com.niit.soft.dao.impl.UserDaoImpl;

/**
 * @author Liang
 * @ClassName DaoFactory
 * @Description TODO
 * @Date 2019/12/2
 * @Version 1.0
 **/
public class DaoFactory {
    public static UserDao getUserDaoInstance(){
     return new UserDaoImpl();
    }
}
