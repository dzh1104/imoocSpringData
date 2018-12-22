package com.imooc.utils;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest {

    @Test
    // 运行该测试方法(右键方法名，运行该方法)
    public void testGetConnection () throws Exception {
        Connection connection = JDBCUtil.getConnection();
        // 不为空，表示拿到Connection
        Assert.assertNotNull(connection);
    }
}
