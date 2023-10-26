package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.PettyLoan;
import com.ssix.project02.service.PettyLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PettyLoanController {
    @Autowired
    private PettyLoanService pettyLoanService;

    @GetMapping(value = "/getPettyLoan")
    public ResultMessage getPettyLoan(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum,int pageSize){
        ResultMessage resultMessage= pettyLoanService.getPettyLoan(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getPettyLoanById/{id}")
    public ResultMessage getPettyLoanById(@PathVariable("id") String id){
        ResultMessage resultMessage = pettyLoanService.getPettyLoanById(Integer.parseInt(id));
        return resultMessage;
    }

    @PostMapping(value = "/addPettyLoan")
    public ResultMessage addPettyLoan(@RequestBody PettyLoan pettyLoan){
        ResultMessage resultMessage= pettyLoanService.addPettyLoan(pettyLoan);
        return  resultMessage;
    }

    @PostMapping(value = "/updatePettyLoan")
    public ResultMessage updatePettyLoan(@RequestBody PettyLoan pettyLoan){
        ResultMessage resultMessage= pettyLoanService.updatePettyLoan(pettyLoan);
        return  resultMessage;
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @GetMapping(value = "/deletePettyLoan/{id}")
    public ResultMessage deletePettyLoan(@PathVariable("id") String id){
        ResultMessage resultMessage = pettyLoanService.deletePettyLoan(Integer.parseInt(id));
        return  resultMessage;
    }
}
