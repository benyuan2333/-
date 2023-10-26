package com.ssix.project02.service;

import com.ssix.project02.dto.ResultMessage;
import org.springframework.stereotype.Service;

@Service
public interface SysUserService {
    public ResultMessage doLogin(String userName, String password);
}