package com.itguigu.mybatis.mapper;

import com.itguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlMapper {
    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param(value = "username") String username);

    /**
     * 根据用户id批量删除用户
     */
    int deleteUserByIds(@Param(value = "ids")String ids);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param(value = "tablename") String tablename);

}
