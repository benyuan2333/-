package com.ssix.project02.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.SalesPersonMapper;
import com.ssix.project02.pojo.SalesPerson;
import com.ssix.project02.service.SalesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesPersonServiceImpl implements SalesPersonService {

    @Autowired
    private SalesPersonMapper salesPersonMapper;

    @Override
    public ResultMessage getSalesPerson(Integer pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);

            List<SalesPerson> list = salesPersonMapper.getSalesPerson();
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
    public ResultMessage getSalesPersonById(int id) {
        try {
            SalesPerson salesPerson = salesPersonMapper.getSalesPersonById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",salesPerson);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addSalesPerson(SalesPerson salesPerson) {
        try{
            int count = salesPersonMapper.addSalesPerson(salesPerson);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updateSalesPerson(SalesPerson salesPerson) {
        try{
            int count = salesPersonMapper.updateSalesPerson(salesPerson);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deleteSalesPerson(int id) {
        try{
            int count = salesPersonMapper.deleteSalesPerson(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
