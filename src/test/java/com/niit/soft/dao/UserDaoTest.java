package com.niit.soft.dao;

import com.niit.soft.entity.User;
import com.niit.soft.factory.DaoFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;


public class UserDaoTest {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    public void findUserByMobile() throws SQLException {
        User user = userDao.findUserByMobile("13917310803");
        System.out.println(user);
    }
    @Test
    public void selectHotUsers() throws SQLException {
        List<User> userList = userDao.selectHotUsers();
        userList.forEach(System.out::println);
    }

}