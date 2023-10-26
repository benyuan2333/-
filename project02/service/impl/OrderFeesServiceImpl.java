package com.ssix.project02.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.OrderFeesMapper;
import com.ssix.project02.pojo.OrderFees;
import com.ssix.project02.service.OrderFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFeesServiceImpl implements OrderFeesService {

    @Autowired
    private OrderFeesMapper orderFeesMapper;

    @Override
    public ResultMessage getOrderFees(Integer pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);

            List<OrderFees> list = orderFeesMapper.getOrderFees();
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
    public ResultMessage getOrderFeesById(int id) {
        try {
            OrderFees orderFees = orderFeesMapper.getOrderFeesById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",orderFees);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addOrderFees(OrderFees orderFees) {
        try{
            int count = orderFeesMapper.addOrderFees(orderFees);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updateOrderFees(OrderFees orderFees) {
        try{
            int count = orderFeesMapper.updateOrderFees(orderFees);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deleteOrderFees(int id) {
        try{
            int count = orderFeesMapper.deleteOrderFees(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
