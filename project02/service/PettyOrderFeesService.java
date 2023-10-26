package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.PettyOrderFees;

public interface PettyOrderFeesService {
    /**
     * 获取所有数据
     * @return
     */
    public ResultMessage getPettyOrderFees(Integer pageNum, int pageSize);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public ResultMessage getPettyOrderFeesById(int id);

    /**
     * 增加信息
     * @param pettyOrderFees
     * @return
     */
    public ResultMessage addPettyOrderFees(PettyOrderFees pettyOrderFees);

    /**
     * 修改信息
     * @param pettyOrderFees
     * @return
     */
    public ResultMessage updatePettyOrderFees(PettyOrderFees pettyOrderFees);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public ResultMessage deletePettyOrderFees(int id);
}
