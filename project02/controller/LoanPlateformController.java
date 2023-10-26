package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.LoanPlateform;
import com.ssix.project02.service.LoanPlateformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanPlateformController {

    @Autowired
    private LoanPlateformService loanPlateformService;

    @GetMapping(value = "/getLoanPlateform")
    public ResultMessage getLoanPlateform(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum,int pageSize){
        ResultMessage resultMessage= loanPlateformService.getLoanPlateform(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getLoanPlateformById/{id}")
    public ResultMessage getLoanPlateformByid(@PathVariable("id") String id){
        ResultMessage resultMessage = loanPlateformService.getLoanPlateformById(Integer.parseInt(id));
        return resultMessage;
    }

    @GetMapping(value = "/findLoanPlateformByName/{loanPlateformName}")
    public ResultMessage findLoanPlateformByName(@PathVariable("loanPlateformName")String loanPlateformName,@RequestParam(name="pageIndex",defaultValue = "1")Integer pageNum,int pageSize) {
        ResultMessage resultMessage= loanPlateformService.findLoanPlateformByName(loanPlateformName,pageNum,pageSize);
        return  resultMessage;
    }

    @PostMapping(value = "/addLoanPlateform")
    public ResultMessage addLoanPlateform(@RequestBody LoanPlateform loanPlateform){
        ResultMessage resultMessage= loanPlateformService.addLoanPlateform(loanPlateform);
        return  resultMessage;
    }

    @PostMapping(value = "/updateLoanPlateform")
    public ResultMessage updateLoanPlateform(@RequestBody LoanPlateform loanPlateform){
        ResultMessage resultMessage= loanPlateformService.updateLoanPlateform(loanPlateform);
        return  resultMessage;
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteLoanPlateform/{id}")
    public ResultMessage deleteLoanPlateform(@PathVariable("id") String id){

        ResultMessage resultMessage = loanPlateformService.deleteLoanPlateform(Integer.parseInt(id));
        return  resultMessage;
    }

}
