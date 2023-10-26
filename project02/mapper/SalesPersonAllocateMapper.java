package com.ssix.project02.mapper;

import com.ssix.project02.pojo.SalesPersonAllocate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesPersonAllocateMapper {
    /**
     * 获取所有数据
     * @return
     */
    public List<SalesPersonAllocate> getSalesPersonAllocate();

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public SalesPersonAllocate getSalesPersonAllocateById(int id);

    /**
     * 增加信息
     * @param salesPersonAllocate
     * @return
     */
    public int addSalesPersonAllocate(SalesPersonAllocate salesPersonAllocate);

    /**
     * 修改信息
     * @param salesPersonAllocate
     * @return
     */
    public int updateSalesPersonAllocate(SalesPersonAllocate salesPersonAllocate);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public int deleteSalesPersonAllocate(int id);

}
