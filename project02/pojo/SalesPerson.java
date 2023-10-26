package com.ssix.project02.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SalesPerson implements java.io.Serializable {
    private  Integer id;
    private  String Name;
    private  String Contact;
    private  String Gender;
    private  Integer Age;
    private  Date HireDate;
}
