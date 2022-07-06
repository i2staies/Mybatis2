package com.itguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    public static SqlSession getSqlSession() {
        //1. 加载核心配置文件
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlServerFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取sqlSessionFactor
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sqlSession
            //优化自动提交事务
            sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

            //代理模式，实例化接口
            //UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //测试功能
            //int i = mapper.insertUser();
            //System.out.println("result:"+i);
            //提交事务
            //sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
