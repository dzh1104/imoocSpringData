package com.imooc.util;

import java.io.InputStream;
import java.sql.Connection;
// 并不是导入这个 import java.mysql.jdbc.Connection
import java.sql.DriverManager;
import java.util.Properties;

/**
 * JDBC工具类
 * 1) 获取Connection
 * 2) 释放资源
 */
public class JDBCUtil {

    /**
     * 获取Connection
     *
     * @return 所获得到的JDBC的Connection
     */
    public static Connection getConnection() throws Exception {

        /**
         * 不建议把配置硬编码到代码中
         *
         * 最佳实践: 配置型的 建议 写到 配置文件中
         */

        // 扫描根路径，因为resources在classpath里面的，所以可以找到
        InputStream inputstream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        // 将db.properties中的内容加载到 properties 中
        properties.load(inputstream);

        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        // 本地固定写法
        // String url = "jdbc:mysql://localhost:3306/spring_data?useSSL=false";
        // String user = "root";
        // String password = "Enuo1010";
        // String driverClass = "com.mysql.cj.jdbc.Driver";

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

}
