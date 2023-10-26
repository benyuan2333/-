package com.ssix.project02.service.impl;

import com.ssix.project02.dto.ResultMessage;
import com.ssix.project02.mapper.SysUserMapper;
import com.ssix.project02.pojo.SysUser;
import com.ssix.project02.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ResultMessage doLogin(String userName, String password) {
        SysUser sysUser = sysUserMapper.doLogin(userName,password);
        if(sysUser!=null){
            return ResultMessage.BY_SUCCESS("登录成功",sysUser);
        }else{
            return ResultMessage.BY_FAIL("登录失败",sysUser);
        }
    }
}