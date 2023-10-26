package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.OrderFees;

public interface OrderFeesService {
    /**
     * 获取所有数据
     * @return
     */
    public ResultMessage getOrderFees(Integer pageNum,int pageSize);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public ResultMessage getOrderFeesById(int id);

    /**
     * 增加信息
     * @param orderFees
     * @return
     */
    public ResultMessage addOrderFees(OrderFees orderFees);

    /**
     * 修改信息
     * @param orderFees
     * @return
     */
    public ResultMessage updateOrderFees(OrderFees orderFees);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public ResultMessage deleteOrderFees(int id);
}
