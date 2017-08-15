package com.xym.spring.transaction;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.sql.Connection;

/**
 * 一定要使用这种方式来调用底层的数据源，融入spring的事务管理环境中
 * 一定要使用这种方式来调用底层的数据源，融入spring的事务管理环境中
 * 一定要使用这种方式来调用底层的数据源，融入spring的事务管理环境中
 *
 * Created by Administrator on 2017/8/15.
 */
public class ConnectionUtils {
    public static void main(String[] args) {
        //通过使用DataSourceUtils，可以获取当前线程中连接资源，这样的数据源迎合了spring的事务管理环境，由spring统一管理事务
        Connection connection = DataSourceUtils.getConnection(new BasicDataSource());
    }
}
