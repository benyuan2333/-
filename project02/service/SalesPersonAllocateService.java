package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.SalesPersonAllocate;

public interface SalesPersonAllocateService {
    /**
     * 获取所有数据
     * @return
     */
    public ResultMessage getSalesPersonAllocate(Integer pageNum, int pageSize);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public ResultMessage getSalesPersonAllocateById(int id);

    /**
     * 增加信息
     * @param salesPersonAllocate
     * @return
     */
    public ResultMessage addSalesPersonAllocate(SalesPersonAllocate salesPersonAllocate);

    /**
     * 修改信息
     * @param salesPersonAllocate
     * @return
     */
    public ResultMessage updateSalesPersonAllocate(SalesPersonAllocate salesPersonAllocate);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public ResultMessage deleteSalesPersonAllocate(int id);
}
