package com.ssix.project02.pojo;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PettyLoan  implements  java.io.Serializable{
    private  Integer id;
    private  String PartyName;
    private  String PartyPhone;
    private  BigDecimal AmountSetting;
    private  BigDecimal Recharge;
    private  BigDecimal CommissionRate;
    private  BigDecimal AutoOffsetFlowCost;
    private  Integer CreditScore;

}