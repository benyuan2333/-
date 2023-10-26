package com.ssix.project02.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SalesPersonAllocate implements java.io.Serializable{
    private  Integer id;
    private  Integer SalespersonID;
    private  Integer OrderID;
    private  String DealStatus;
    private  Date DealTime;
    private  Date CreateTime;
    private  Date UpdateTime;
}
