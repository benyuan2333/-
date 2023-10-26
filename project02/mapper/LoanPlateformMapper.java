package com.ssix.project02.mapper;

import com.ssix.project02.pojo.LoanPlateform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoanPlateformMapper {
    /**
     * 获取所有贷款平台数据
     * @return
     */
    public List<LoanPlateform> getLoanPlateform();
    public List<LoanPlateform> findLoanPlateformByName(String loanPlateformName);

    /**
     * 根据ID获取贷款平台数据
     * @param id
     * @return
     */
    public LoanPlateform getLoanPlateformById(int id);

    /**
     * 增加贷款平台信息
     * @param loanPlateform
     * @return
     */
    public int addLoanPlateform(LoanPlateform loanPlateform);

    /**
     * 修改贷款平台信息
     * @param loanPlateform
     * @return
     */
    public int updateLoanPlateform(LoanPlateform loanPlateform);

    /**
     * 根据ID 删除贷款平台信息
     * @param id
     * @return
     */
    public int deleteLoanPlateform(int id);
}
