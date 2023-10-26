package com.ssix.project02.mapper;


import com.ssix.project02.pojo.CustInteract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustInteractMapper {
    /**
     * 获取所有数据
     * @return
     */
    public List<CustInteract> getCustInteract();

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public CustInteract getCustInteractById(int id);

    /**
     * 增加信息
     * @param custInteract
     * @return
     */
    public int addCustInteract(CustInteract custInteract);

    /**
     * 修改信息
     * @param custInteract
     * @return
     */
    public int updateCustInteract(CustInteract custInteract);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public int deleteCustInteract(int id);
}
