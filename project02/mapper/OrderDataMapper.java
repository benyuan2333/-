package com.ssix.project02.mapper;

import com.ssix.project02.pojo.OrderData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDataMapper {
    /**
     * 获取所有数据
     * @return
     */
    public List<OrderData> getOrderData();

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public OrderData getOrderDataById(int id);

    /**
     * 增加信息
     * @param orderData
     * @return
     */
    public int addOrderData(OrderData orderData);

    /**
     * 修改信息
     * @param orderData
     * @return
     */
    public int updateOrderData(OrderData orderData);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public int deleteOrderData(int id);
}
