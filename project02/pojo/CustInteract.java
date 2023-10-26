package com.ssix.project02.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class CustInteract implements java.io.Serializable{
    private  Integer id;
    private  Integer SalespersonID;
    private  Integer OrderID;
    private  String InteractionInfo;
    private  Date CreateTime;
    private  Date UpdateTime;
}
