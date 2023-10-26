package com.ssix.project02.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.LoanPlateformMapper;
import com.ssix.project02.pojo.LoanPlateform;
import com.ssix.project02.service.LoanPlateformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanPlateformServiceImpl implements LoanPlateformService {

    @Autowired
    private LoanPlateformMapper loanPlateformMapper;

    @Override
    public ResultMessage getLoanPlateform(Integer pageNum,int pageSize) {

        try {
            PageHelper.startPage(pageNum,pageSize);

            List<LoanPlateform> list = loanPlateformMapper.getLoanPlateform();
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
    public ResultMessage findLoanPlateformByName(String loanPlateformName,Integer pageNum,int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<LoanPlateform> list  = loanPlateformMapper.findLoanPlateformByName(loanPlateformName);
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
    public ResultMessage getLoanPlateformById(int id) {
        try {
            LoanPlateform loanPlateform = loanPlateformMapper.getLoanPlateformById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",loanPlateform);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addLoanPlateform(LoanPlateform loanPlateform) {
        try{
            int count = loanPlateformMapper.addLoanPlateform(loanPlateform);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_SUCCESS("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updateLoanPlateform(LoanPlateform loanPlateform) {
        try{
            int count = loanPlateformMapper.updateLoanPlateform(loanPlateform);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deleteLoanPlateform(int id) {
        try{
            int count = loanPlateformMapper.deleteLoanPlateform(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
