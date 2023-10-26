package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.OrderFees;
import com.ssix.project02.service.OrderFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderFeesController {
    @Autowired
    private OrderFeesService orderFeesService;

    @GetMapping(value = "/getOrderFees")
    public ResultMessage getOrderData(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum, int pageSize){
        ResultMessage resultMessage= orderFeesService.getOrderFees(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getOrderFeesById/{id}")
    public ResultMessage getOrderFeesById(@PathVariable("id") String id){
        ResultMessage resultMessage = orderFeesService.getOrderFeesById(Integer.parseInt(id));
        return resultMessage;
    }

    @PostMapping(value = "/addOrderFees")
    public ResultMessage addOrderFees(@RequestBody OrderFees orderFees){
        ResultMessage resultMessage= orderFeesService.addOrderFees(orderFees);
        return  resultMessage;
    }

    @PostMapping(value = "/updateOrderFees")
    public ResultMessage updateOrderFees(@RequestBody OrderFees orderFees){
        ResultMessage resultMessage= orderFeesService.updateOrderFees(orderFees);
        return  resultMessage;
    }

    @GetMapping(value = "/deleteOrderFees/{id}")
    public ResultMessage deleteOrderFees(@PathVariable("id") String id){
        ResultMessage resultMessage = orderFeesService.deleteOrderFees(Integer.parseInt(id));
        return  resultMessage;
    }
}
