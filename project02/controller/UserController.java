package com.ssix.project02.controller;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping(value = "/doLogin")
    public ResultMessage doLogin(String userName,String password){
        ResultMessage resultMessage = sysUserService.doLogin(userName,password);
        return  resultMessage;
    }
}