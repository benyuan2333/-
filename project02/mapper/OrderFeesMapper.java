package com.ssix.project02.mapper;

import com.ssix.project02.pojo.OrderFees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderFeesMapper {
    /**
     * 获取所有数据
     * @return
     */
    public List<OrderFees> getOrderFees();

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public OrderFees getOrderFeesById(int id);

    /**
     * 增加信息
     * @param orderFees
     * @return
     */
    public int addOrderFees(OrderFees orderFees);

    /**
     * 修改信息
     * @param orderFees
     * @return
     */
    public int updateOrderFees(OrderFees orderFees);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public int deleteOrderFees(int id);
}
