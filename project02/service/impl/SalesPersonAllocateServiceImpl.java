package com.ssix.project02.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.SalesPersonAllocateMapper;
import com.ssix.project02.pojo.SalesPersonAllocate;
import com.ssix.project02.service.SalesPersonAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesPersonAllocateServiceImpl implements SalesPersonAllocateService {

    @Autowired
    private SalesPersonAllocateMapper salesPersonAllocateMapper;

    @Override
    public ResultMessage getSalesPersonAllocate(Integer pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);

            List<SalesPersonAllocate> list = salesPersonAllocateMapper.getSalesPersonAllocate();
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
    public ResultMessage getSalesPersonAllocateById(int id) {
        try {
            SalesPersonAllocate salesPersonAllocate = salesPersonAllocateMapper.getSalesPersonAllocateById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",salesPersonAllocate);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addSalesPersonAllocate(SalesPersonAllocate salesPersonAllocate) {
        try{
            int count = salesPersonAllocateMapper.addSalesPersonAllocate(salesPersonAllocate);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updateSalesPersonAllocate(SalesPersonAllocate salesPersonAllocate) {
        try{
            int count = salesPersonAllocateMapper.updateSalesPersonAllocate(salesPersonAllocate);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deleteSalesPersonAllocate(int id) {
        try{
            int count = salesPersonAllocateMapper.deleteSalesPersonAllocate(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
