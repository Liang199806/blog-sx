package com.niit.soft.service.impl;

import com.niit.soft.dao.UserDao;
import com.niit.soft.domain.Vo.UserVo;
import com.niit.soft.domain.dto.UserDto;
import com.niit.soft.entity.User;
import com.niit.soft.factory.DaoFactory;
import com.niit.soft.service.UserService;
import com.niit.soft.util.Result;
import com.niit.soft.util.ResultCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;


/**
 * @author Liang
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Result signIn(UserDto userDto) {
        User user = null;
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现问题");
        }
        if (user != null) {
            if (user.getPassword().equals(DigestUtils.md5Hex(userDto.getPassword()))) {
                return Result.success(user);
            }else {
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        }else {
            return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
        }
    }

    @Override
    public Result getHotUsers() {
        List<User> userList = null;
        try {
            userList = userDao.selectHotUsers();
        } catch (SQLException e) {
            logger.error("获取热门用户出现异常");
        }
        if (userList != null) {
            //成功并返回数据
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
    @Override
    public Result selectByPage(int currentPage, int count) {
        List<User> userList = null;
        try {
            userList = userDao.selectByPage(currentPage, count);
        } catch (
                SQLException e) {
            logger.error("分页查询用户出现异常");
        }
        if (userList != null) {
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

}
