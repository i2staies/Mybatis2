package com.itguigu.mybatis.test;

import com.itguigu.mybatis.mapper.ParameterMapper;
import com.itguigu.mybatis.pojo.User;
import com.itguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /**
     * 1. mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的名称获取参数值，但是需要注意${}的单引号问题
     * 2. mapper 接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a> 以 arg0, arg1...为键，以参数为值
     * b> 以 param1, param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3，若mapper接口方法的参数有多个时，可以手动将这些 参数放在一个map 中存储
     * 只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4. mapper接口方法的参数是实体类类型
     */
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //代理模式，实例化接口
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        //测试功能
        List<User> allUser = mapper.getAllUser();
        allUser.forEach (System.out::println);
        //提交事务
        //sqlSession.commit();
    }

    @Test
    public void testGetUserByName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //代理模式，实例化接口
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        //测试功能
        User user = mapper.getUserByName("李四");
        System.out.println(user);
        //提交事务
        //sqlSession.commit();
    }

    @Test
    public void testCheckUserPwd(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //代理模式，实例化接口
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        //测试功能
        User user = mapper.checkUserPwd("李四","123");
        System.out.println(user);
        //提交事务
        //sqlSession.commit();
    }

    @Test
    public void testCheckUserPwdMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //代理模式，实例化接口
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        //测试功能
        Map<String,Object> map = new HashMap<>();
        map.put("username", "李四");
        map.put("password", "123");
        User user = mapper.checkUserPwdMap(map);
        System.out.println(user);
        //提交事务
        //sqlSession.commit();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //代理模式，实例化接口
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        //测试功能
        Integer i = mapper.insertUser(new User(null, "ZLP", "123456", 11, '男', "111@qq"));
        //提交事务
        //sqlSession.commit();
    }

    @Test
    public void testCheckUserPwdByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //代理模式，实例化接口
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        //测试功能

        User user = mapper.checkUserPwdByParam("ZLP","123456");
        System.out.println(user);
        //提交事务
        //sqlSession.commit();
    }
}
