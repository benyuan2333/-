package com.ssix.project02.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PettyOrderFees implements java.io.Serializable{
    private  Integer id;
    private  Integer OrderID;
    private  Integer LoanPlatformID;
    private BigDecimal Amount;
    private Date createTime;
    private  Date updateTime;
}
