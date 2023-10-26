package com.ssix.project02.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class LoanPlateform  implements  java.io.Serializable{
    private Integer id;
    private String loanPlateformName;
    private Integer loanPlateformStatus ;
    private String loanType;
    private Integer clientNum;
    private BigDecimal moneySet;
    private Date createTime;
    private Date updateTime;
}