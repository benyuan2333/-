package com.ssix.project02.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderData implements java.io.Serializable {
    private  Integer id;
    private  String name;
    private  String gender;
    private  String phone;
    private  Integer age;
    private  Integer accFund;
    private  String occupation;
    private  String incomeType;
    private  Integer sesameScore;
    private  String creditCard;
    private  Date createTime;
    private  Date updateTime;
    private  Integer platformId;
}
