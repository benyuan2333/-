package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.SalesPerson;

public interface SalesPersonService {
    /**
     * 获取所有数据
     * @return
     */
    public ResultMessage getSalesPerson(Integer pageNum, int pageSize);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public ResultMessage getSalesPersonById(int id);

    /**
     * 增加信息
     * @param salesPerson
     * @return
     */
    public ResultMessage addSalesPerson(SalesPerson salesPerson);

    /**
     * 修改信息
     * @param salesPerson
     * @return
     */
    public ResultMessage updateSalesPerson(SalesPerson salesPerson);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public ResultMessage deleteSalesPerson(int id);
}
