package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.OrderData;

public interface OrderDataService {
    /**
     * 获取所有数据
     * @return
     */
    public ResultMessage getOrderData(Integer pageNum,int pageSize);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public ResultMessage getOrderDataById(int id);

    /**
     * 增加信息
     * @param orderData
     * @return
     */
    public ResultMessage addOrderData(OrderData orderData);

    /**
     * 修改信息
     * @param orderData
     * @return
     */
    public ResultMessage updateOrderData(OrderData orderData);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public ResultMessage deleteOrderData(int id);
}
