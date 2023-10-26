package com.ssix.project02.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.CustInteractMapper;
import com.ssix.project02.pojo.CustInteract;
import com.ssix.project02.service.CustInteractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustInteractServiceImpl implements CustInteractService {

    @Autowired
    private CustInteractMapper custInteractMapper;

    @Override
    public ResultMessage getCustInteract(Integer pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);

            List<CustInteract> list = custInteractMapper.getCustInteract();
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
    public ResultMessage getCustInteractById(int id) {
        try {
            CustInteract custInteract = custInteractMapper.getCustInteractById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",custInteract);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addCustInteract(CustInteract custInteract) {
        try{
            int count = custInteractMapper.addCustInteract(custInteract);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updateCustInteract(CustInteract custInteract) {
        try{
            int count = custInteractMapper.updateCustInteract(custInteract);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deleteCustInteract(int id) {
        try{
            int count = custInteractMapper.deleteCustInteract(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
