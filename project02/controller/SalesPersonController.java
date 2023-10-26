package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.SalesPerson;
import com.ssix.project02.service.SalesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalesPersonController {

    @Autowired
    private SalesPersonService salesPersonService;

    @GetMapping(value = "/getSalesPerson")
    public ResultMessage getSalesPerson(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum, int pageSize){
        ResultMessage resultMessage= salesPersonService.getSalesPerson(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getSalesPersonById/{id}")
    public ResultMessage getSalesPersonById(@PathVariable("id") String id){
        ResultMessage resultMessage = salesPersonService.getSalesPersonById(Integer.parseInt(id));
        return resultMessage;
    }

    @PostMapping(value = "/addSalesPerson")
    public ResultMessage addSalesPerson(@RequestBody SalesPerson salesPerson){
        ResultMessage resultMessage= salesPersonService.addSalesPerson(salesPerson);
        return  resultMessage;
    }

    @PostMapping(value = "/updateSalesPerson")
    public ResultMessage updateSalesPerson(@RequestBody SalesPerson salesPerson){
        ResultMessage resultMessage= salesPersonService.updateSalesPerson(salesPerson);
        return  resultMessage;
    }

    @GetMapping(value = "/deleteSalesPerson/{id}")
    public ResultMessage deleteSalesPerson(@PathVariable("id") String id){
        ResultMessage resultMessage = salesPersonService.deleteSalesPerson(Integer.parseInt(id));
        return  resultMessage;
    }

}
