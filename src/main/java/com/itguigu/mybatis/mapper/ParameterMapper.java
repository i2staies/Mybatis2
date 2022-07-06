package com.itguigu.mybatis.mapper;

import com.itguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    /**
     * 查询所以员工信息
     */
    List<User> getAllUser();


    /**
     * 根据用户名查询用户信息
     */
    User getUserByName(String name);

    /**
     *验证账号密码
     */
    User checkUserPwd(String name,String password);

    /**
     * 通过Map集合存储账号密码来验证
     */
    User checkUserPwdMap(Map<String,Object> map);

    /**
     * 通过@Param标签进行check验证
     */
    User checkUserPwdByParam(@Param(value = "username")String name,@Param(value = "password")String pwd);

    /**
     * 插入用户数据
     */
    Integer insertUser(User user);


}
