package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.CustInteract;

public interface CustInteractService {
    /**
     * 获取所有数据
     * @return
     */
    public ResultMessage getCustInteract(Integer pageNum, int pageSize);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    public ResultMessage getCustInteractById(int id);

    /**
     * 增加信息
     * @param custInteract
     * @return
     */
    public ResultMessage addCustInteract(CustInteract custInteract);

    /**
     * 修改信息
     * @param custInteract
     * @return
     */
    public ResultMessage updateCustInteract(CustInteract custInteract);

    /**
     * 根据ID 删除信息
     * @param id
     * @return
     */
    public ResultMessage deleteCustInteract(int id);
}
