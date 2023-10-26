package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.PettyLoan;

public interface PettyLoanService {
    /**
     * 获取所有数据
     * @return
     */
    public ResultMessage getPettyLoan(Integer pageNum,int pageSize);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public ResultMessage getPettyLoanById(int id);

    /**
     * 增加信息
     * @param pettyLoan
     * @return
     */
    public ResultMessage addPettyLoan(PettyLoan pettyLoan);

    /**
     * 修改信息
     * @param pettyLoan
     * @return
     */
    public ResultMessage updatePettyLoan(PettyLoan pettyLoan);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public ResultMessage deletePettyLoan(int id);
}
