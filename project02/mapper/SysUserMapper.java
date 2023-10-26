package com.ssix.project02.mapper;
import com.ssix.project02.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    public SysUser doLogin(String userName, String password);
}
