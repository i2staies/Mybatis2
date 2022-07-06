package com.itguigu.mybatis.mapper;

import com.itguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MyBatis.的各种查询功能:
 * 1.若查询出的数据只有- -条
 * a>可以通过实体类对象接收
 * b>可以通过ist集合接收
 *
 * 2.若查询出的数据有多条
 * a>可以通过list集合接收
 * 注意: 一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
 */
public interface SelectMapper {
    /**
     * 根据id查询用户信息
     */
    /*User*/List<User> getUserById(@Param(value = "id")Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getUserAll();

    /**
     * 查询用户总记录数
     */
    Integer getCount();

    /**
     *根据id查询用户信息为一个Map集合
     */
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     *查询所有用户的map集合(以id为键，其他属性为值)
     */
    @MapKey(value = "id")
    Map<String,Object> getUserAllToMap();

    /**
     * 查询所有用户的map集合
     */
    List<Map<String,Object>> getUserAllToMaps();

}
