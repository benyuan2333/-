package com.ssix.project02.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.OrderDataMapper;
import com.ssix.project02.pojo.OrderData;
import com.ssix.project02.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {

    @Autowired
    private OrderDataMapper orderDataMapper;

    @Override
    public ResultMessage getOrderData(Integer pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);

            List<OrderData> list = orderDataMapper.getOrderData();
            PageInfo pageInfo = new PageInfo(list);
            ResultMessage  resultMessage=  ResultMessage.BY_SUCCESS("获取数据成功",list);
            resultMessage.setPageInfo(pageInfo);
            return resultMessage ;
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage getOrderDataById(int id) {
        try {
            OrderData orderData = orderDataMapper.getOrderDataById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",orderData);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addOrderData(OrderData orderData) {
        try{
            int count = orderDataMapper.addOrderData(orderData);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updateOrderData(OrderData orderData) {
        try{
            int count = orderDataMapper.updateOrderData(orderData);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deleteOrderData(int id) {
        try{
            int count = orderDataMapper.deleteOrderData(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
