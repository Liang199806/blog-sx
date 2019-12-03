package com.niit.soft.domain.Vo;

import com.niit.soft.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author Liang
 * @ClassName UserVo
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
@Data
public class UserVo {
    private User user;
    private List<User> fansList;
}
