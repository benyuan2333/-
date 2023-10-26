package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.OrderData;
import com.ssix.project02.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDataController {
    @Autowired
    private OrderDataService orderDataService;

    @GetMapping(value = "/getOrderData")
    public ResultMessage getOrderData(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum, int pageSize){
        ResultMessage resultMessage= orderDataService.getOrderData(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getOrderDataById/{id}")
    public ResultMessage getOrderDataById(@PathVariable("id") String id){
        ResultMessage resultMessage = orderDataService.getOrderDataById(Integer.parseInt(id));
        return resultMessage;
    }

    @PostMapping(value = "/addOrderData")
    public ResultMessage addOrderData(@RequestBody OrderData orderData){
        ResultMessage resultMessage= orderDataService.addOrderData(orderData);
        return  resultMessage;
    }

    @PostMapping(value = "/updateOrderData")
    public ResultMessage updateOrderData(@RequestBody OrderData orderData){
        ResultMessage resultMessage= orderDataService.updateOrderData(orderData);
        return  resultMessage;
    }

    @GetMapping(value = "/deleteOrderData/{id}")
    public ResultMessage deleteOrderData(@PathVariable("id") String id){
        ResultMessage resultMessage = orderDataService.deleteOrderData(Integer.parseInt(id));
        return  resultMessage;
    }
}
