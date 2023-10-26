package com.ssix.project02.mapper;

import com.ssix.project02.pojo.PettyLoan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PettyLoanMapper {
    /**
     * 获取所有数据
     * @return
     */
    public List<PettyLoan> getPettyLoan();

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public PettyLoan getPettyLoanById(int id);

    /**
     * 增加信息
     * @param pettyLoan
     * @return
     */
    public int addPettyLoan(PettyLoan pettyLoan);

    /**
     * 修改信息
     * @param pettyLoan
     * @return
     */
    public int updatePettyLoan(PettyLoan pettyLoan);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public int deletePettyLoan(int id);
}
