package com.ssix.project02.mapper;

import com.ssix.project02.pojo.PettyOrderFees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PettyOrderFeesMapper {
    /**
     * 获取所有数据
     * @return
     */
    public List<PettyOrderFees> getPettyOrderFees();

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public PettyOrderFees getPettyOrderFeesById(int id);

    /**
     * 增加信息
     * @param pettyOrderFees
     * @return
     */
    public int addPettyOrderFees(PettyOrderFees pettyOrderFees);

    /**
     * 修改信息
     * @param pettyOrderFees
     * @return
     */
    public int updatePettyOrderFees(PettyOrderFees pettyOrderFees);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public int deletePettyOrderFees(int id);
}
