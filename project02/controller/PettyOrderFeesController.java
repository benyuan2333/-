package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.pojo.PettyOrderFees;
import com.ssix.project02.service.PettyOrderFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PettyOrderFeesController {
    @Autowired
    private PettyOrderFeesService pettyOrderFeesService;

    @GetMapping(value = "/getPettyOrderFees")
    public ResultMessage getPettyOrderData(@RequestParam(name="pageIndex",defaultValue = "1") Integer pageNum, int pageSize){
        ResultMessage resultMessage= pettyOrderFeesService.getPettyOrderFees(pageNum,pageSize);
        return  resultMessage;
    }

    @GetMapping(value = "/getPettyOrderFeesById/{id}")
    public ResultMessage getPettyOrderFeesById(@PathVariable("id") String id){
        ResultMessage resultMessage = pettyOrderFeesService.getPettyOrderFeesById(Integer.parseInt(id));
        return resultMessage;
    }

    @PostMapping(value = "/addPettyOrderFees")
    public ResultMessage addPettyOrderFees(@RequestBody PettyOrderFees pettyOrderFees){
        ResultMessage resultMessage= pettyOrderFeesService.addPettyOrderFees(pettyOrderFees);
        return  resultMessage;
    }

    @PostMapping(value = "/updatePettyOrderFees")
    public ResultMessage updatePettyOrderFees(@RequestBody PettyOrderFees pettyOrderFees){
        ResultMessage resultMessage= pettyOrderFeesService.updatePettyOrderFees(pettyOrderFees);
        return  resultMessage;
    }

    @GetMapping(value = "/deletePettyOrderFees/{id}")
    public ResultMessage deletePettyOrderFees(@PathVariable("id") String id){
        ResultMessage resultMessage = pettyOrderFeesService.deletePettyOrderFees(Integer.parseInt(id));
        return  resultMessage;
    }

}
