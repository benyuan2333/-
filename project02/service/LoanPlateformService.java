package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.LoanPlateform;

public interface LoanPlateformService {
    /**
     * 获取所有贷款平台数据
     * @return
     */
    public ResultMessage getLoanPlateform(Integer pageNum,int pageSize);

    public ResultMessage findLoanPlateformByName(String loanPlateformName,Integer pageNum,int pageSize);
    /**
     * 根据ID获取贷款平台数据
     * @param id
     * @return
     */
    public ResultMessage getLoanPlateformById(int id);

    /**
     * 增加贷款平台信息
     * @param loanPlateform
     * @return
     */
    public ResultMessage addLoanPlateform(LoanPlateform loanPlateform);

    /**
     * 修改贷款平台信息
     * @param loanPlateform
     * @return
     */
    public ResultMessage updateLoanPlateform(LoanPlateform loanPlateform);

    /**
     * 根据ID 删除贷款平台信息
     * @param id
     * @return
     */
    public ResultMessage deleteLoanPlateform(int id);
}
