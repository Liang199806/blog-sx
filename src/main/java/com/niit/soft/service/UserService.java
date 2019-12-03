package com.niit.soft.service;

import com.niit.soft.domain.dto.UserDto;
import com.niit.soft.util.Result;

/**
 * @author Liang
 * @ClassName UserService
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
public interface UserService {

    Result signIn(UserDto userDto);

    Result getHotUsers();

    Result selectByPage(int currentPage,int count);
}
