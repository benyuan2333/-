package com.ssix.project02.pojo;

import lombok.Data;

@Data
public class SysUser implements java.io.Serializable{
    private int id;
    private  String username;
    private  String password;
    private String real_name;
    private String tel;
    private  String email;
}