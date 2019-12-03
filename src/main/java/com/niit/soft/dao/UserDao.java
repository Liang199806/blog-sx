package com.niit.soft.dao;

import com.niit.soft.domain.Vo.UserVo;
import com.niit.soft.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Liang
 * @ClassName UserDao
 * @Description TODO
 * @Date 2019/12/2
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 批量新增用户
     *
     * @param userList
     * @throws SQLException
     */
    void batchInsert(List<User> userList) throws SQLException;

    /**
     * 根据手机号查找用户
     *
     * @return
     * @throws SQLException
     */
    User findUserByMobile(String mobile) throws SQLException;

    /**
     * 查找热门用户
     *
     * @return
     * @throws SQLException
     */
    List<User> selectHotUsers() throws SQLException;

    /**
     * 分页查询用户
     *
     * @return
     * @throws SQLException
     */
    List<User> selectByPage(int currentPage, int count) throws SQLException;

}