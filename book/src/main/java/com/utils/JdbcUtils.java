package com.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
//    获取数据库连接池中的连接
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    static {
        try
        {
            Properties properties = new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    //如果返回null，说明获取连接失败
    public static Connection getConnection(){

        Connection conn = conns.get();
        if (conn==null)
        {
            try {
                conn=dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);//设置手动管理事务
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;

    }
    public static void rollbackAndClose()
    {
        Connection connection = conns.get();
        if (connection!=null)
        {
            try {
                connection.rollback();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }


    public static void commitAndClose()
    {
        Connection connection = conns.get();
        if (connection!=null)
        {
            try {
                connection.commit();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        conns.remove();//一定要remove，因为tomcat使用了线程池技术
    }
//    关闭连接，放回数据库连接池
/*    public static void close(Connection conn){


        if (conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }*/
}
