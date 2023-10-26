package com.ssix.project02.controller;


import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.SalesPersonAllocate;
import com.ssix.project02.service.SalesPersonAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalesPersonAllocateController {

    @Autowired
    private SalesPersonAllocateService salesPersonAllocateService;

    @GetMapping(value = "/getSalesPersonAllocate")
    public ResultMessage getSalesPersonAllocate(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum, int pageSize){
        ResultMessage resultMessage= salesPersonAllocateService.getSalesPersonAllocate(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getSalesPersonAllocateById/{id}")
    public ResultMessage getSalesPersonAllocateById(@PathVariable("id") String id){
        ResultMessage resultMessage = salesPersonAllocateService.getSalesPersonAllocateById(Integer.parseInt(id));
        return resultMessage;
    }

    @PostMapping(value = "/addSalesPersonAllocate")
    public ResultMessage addSalesPersonAllocate(@RequestBody SalesPersonAllocate salesPersonAllocate){
        ResultMessage resultMessage= salesPersonAllocateService.addSalesPersonAllocate(salesPersonAllocate);
        return  resultMessage;
    }

    @PostMapping(value = "/updateSalesPersonAllocate")
    public ResultMessage updateSalesPersonAllocate(@RequestBody SalesPersonAllocate salesPersonAllocate){
        ResultMessage resultMessage= salesPersonAllocateService.updateSalesPersonAllocate(salesPersonAllocate);
        return  resultMessage;
    }

    @GetMapping(value = "/deleteSalesPersonAllocate/{id}")
    public ResultMessage deleteSalesPersonAllocate(@PathVariable("id") String id){
        ResultMessage resultMessage = salesPersonAllocateService.deleteSalesPersonAllocate(Integer.parseInt(id));
        return  resultMessage;
    }

}
