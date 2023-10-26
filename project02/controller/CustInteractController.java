package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.CustInteract;
import com.ssix.project02.service.CustInteractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustInteractController {
    @Autowired
    private CustInteractService custInteractService;

    @GetMapping(value = "/getCustInteract")
    public ResultMessage getCustInteract(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum,int pageSize){
        ResultMessage resultMessage= custInteractService.getCustInteract(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getCustInteractById/{id}")
    public ResultMessage getCustInteractById(@PathVariable("id") String id){
        ResultMessage resultMessage = custInteractService.getCustInteractById(Integer.parseInt(id));
        return resultMessage;
    }

    @PostMapping(value = "/addCustInteract")
    public ResultMessage addCustInteract(@RequestBody CustInteract custInteract){
        ResultMessage resultMessage= custInteractService.addCustInteract(custInteract);
        return  resultMessage;
    }

    @PostMapping(value = "/updateCustInteract")
    public ResultMessage updateCustInteract(@RequestBody CustInteract custInteract){
        ResultMessage resultMessage= custInteractService.updateCustInteract(custInteract);
        return  resultMessage;
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteCustInteract/{id}")
    public ResultMessage deleteCustInteract(@PathVariable("id") String id){
        ResultMessage resultMessage = custInteractService.deleteCustInteract(Integer.parseInt(id));
        return  resultMessage;
    }
}
