package com.niit.soft.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liang
 * @ClassName UserDto
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
@Data
public class UserDto implements Serializable {
    private String mobile;
    private String password;
    private String code;

}