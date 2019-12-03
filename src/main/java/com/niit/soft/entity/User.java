package com.niit.soft.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Liang
 * @ClassName User
 * @Description TODO
 * @Date 2019/12/2
 * @Version 1.0
 **/

@Data
public class User {
    private Long id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String introduction;
    private String banner;
    private String email;
    private String homepage;
    private Integer follows;
    private Integer fans;
    private Integer articles;
    private LocalDateTime createTime;
    private Short status;
}