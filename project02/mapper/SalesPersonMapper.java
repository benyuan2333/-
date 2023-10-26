package com.ssix.project02.mapper;

import com.ssix.project02.pojo.SalesPerson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesPersonMapper {
    /**
     * 获取所有数据
     * @return
     */
    public List<SalesPerson> getSalesPerson();

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public SalesPerson getSalesPersonById(int id);

    /**
     * 增加信息
     * @param salesPerson
     * @return
     */
    public int addSalesPerson(SalesPerson salesPerson);

    /**
     * 修改信息
     * @param salesPerson
     * @return
     */
    public int updateSalesPerson(SalesPerson salesPerson);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public int deleteSalesPerson(int id);
}
