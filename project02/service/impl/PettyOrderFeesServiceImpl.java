package com.ssix.project02.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.PettyOrderFeesMapper;
import com.ssix.project02.pojo.PettyOrderFees;
import com.ssix.project02.service.PettyOrderFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PettyOrderFeesServiceImpl implements PettyOrderFeesService {

    @Autowired
    private PettyOrderFeesMapper pettyOrderFeesMapper;

    @Override
    public ResultMessage getPettyOrderFees(Integer pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);

            List<PettyOrderFees> list = pettyOrderFeesMapper.getPettyOrderFees();
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
    public ResultMessage getPettyOrderFeesById(int id) {
        try {
            PettyOrderFees pettyOrderFees = pettyOrderFeesMapper.getPettyOrderFeesById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",pettyOrderFees);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addPettyOrderFees(PettyOrderFees pettyOrderFees) {
        try{
            int count = pettyOrderFeesMapper.addPettyOrderFees(pettyOrderFees);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updatePettyOrderFees(PettyOrderFees pettyOrderFees) {
        try{
            int count = pettyOrderFeesMapper.updatePettyOrderFees(pettyOrderFees);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deletePettyOrderFees(int id) {
        try{
            int count = pettyOrderFeesMapper.deletePettyOrderFees(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
