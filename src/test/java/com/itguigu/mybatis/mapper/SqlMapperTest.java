package com.itguigu.mybatis.mapper;

import com.itguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SqlMapperTest {
    @Test
    public void testGetUserAllToMaps(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        System.out.println(mapper.getUserByLike("张"));
    }

    @Test
    public void testDeleteUserByIds(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        System.out.println(mapper.deleteUserByIds("19,20"));
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        System.out.println(mapper.getUserByTableName("t_user"));
    }
}
