package com.ssix.project02.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.PettyLoanMapper;
import com.ssix.project02.pojo.PettyLoan;
import com.ssix.project02.service.PettyLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PettyLoanServiceImpl implements PettyLoanService {
    @Autowired
    private PettyLoanMapper pettyLoanMapper;

    @Override
    public ResultMessage getPettyLoan(Integer pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);

            List<PettyLoan> list = pettyLoanMapper.getPettyLoan();
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
    public ResultMessage getPettyLoanById(int id) {
        try {
            PettyLoan pettyLoan = pettyLoanMapper.getPettyLoanById(id);
            return  ResultMessage.BY_SUCCESS("获取数据成功",pettyLoan);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("获取数据失败",null);
        }
    }

    @Override
    public ResultMessage addPettyLoan(PettyLoan pettyLoan) {
        try{
            int count = pettyLoanMapper.addPettyLoan(pettyLoan);
            return  ResultMessage.BY_SUCCESS("数据保存成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据保存失败！",0);
        }
    }

    @Override
    public ResultMessage updatePettyLoan(PettyLoan pettyLoan) {
        try{
            int count = pettyLoanMapper.updatePettyLoan(pettyLoan);
            return  ResultMessage.BY_SUCCESS("数据修改成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据修改失败！",0);
        }
    }

    @Override
    public ResultMessage deletePettyLoan(int id) {
        try{
            int count = pettyLoanMapper.deletePettyLoan(id);
            return  ResultMessage.BY_SUCCESS("数据删除成功",count);
        }catch (Exception ex){
            ex.printStackTrace();
            return  ResultMessage.BY_FAIL("数据删除失败！",0);
        }
    }
}
