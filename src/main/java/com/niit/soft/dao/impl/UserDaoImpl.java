package com.niit.soft.dao.impl;

import com.niit.soft.dao.UserDao;
import com.niit.soft.domain.Vo.UserVo;
import com.niit.soft.entity.User;
import com.niit.soft.util.BeanHandler;
import com.niit.soft.util.DbUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Liang
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Date 2019/12/2
 * @Version 1.0
 **/
public class UserDaoImpl implements UserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public void batchInsert(List<User> userList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_user (id,mobile,password,nickname,avatar,gender,birthday,address,introduction,banner,homepage,follows,fans,articles,create_time,status) VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement us = connection.prepareStatement(sql);
        userList.forEach(user -> {
            try {
                us.setString(1, user.getMobile());
                us.setString(2, user.getPassword());
                us.setString(3, user.getNickname());
                us.setString(4, user.getAvatar());
                us.setString(5, user.getGender());
                us.setObject(6, user.getBirthday());
                us.setString(7, user.getAddress());
                us.setString(8, user.getIntroduction());
                us.setString(9, user.getBanner());
                us.setString(10, user.getHomepage());
                us.setInt(11, 0);
                us.setInt(12, 0);
                us.setInt(13, 0);
                us.setObject(14, user.getCreateTime());
                us.setShort(15, user.getStatus());
                us.addBatch();
            } catch (SQLException e) {
                logger.error("批量加入用户数据产生异常");
            }
        });
        us.executeBatch();
        connection.commit();
        DbUtil.close(connection, us);
    }

    @Override
    public User findUserByMobile(String mobile) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE mobile = ? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, mobile);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        User user = null;
        if (userList.size() != 0) {
            user = userList.get(0);
        }
        DbUtil.close(connection, pst, rs);
        return user;
    }

    @Override
    public List<User> selectHotUsers() throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user ORDER BY fans DESC LIMIT 10 ";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        DbUtil.close(connection, pst, rs);
        return userList;
    }
    @Override
    public List<User> selectByPage(int currentPage, int count) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user LIMIT ?,? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, (currentPage - 1) * count);
        pst.setInt(2, count);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        DbUtil.close(connection, pst, rs);
        return userList;
    }
}
