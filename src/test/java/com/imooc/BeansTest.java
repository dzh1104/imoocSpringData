package com.imooc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;

// 对beans.xml中的配置进行测试
public class BeansTest {

    // 使用spring开发，会存在一个ApplicationContext类型的对象，保存着上下文的信息
    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        // 测试前创建ctx
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        // 测试后销毁ctx
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource() {

        System.out.println("testDataSource");
        // 从spring容器中取得对象
        // getBean返回值是Object类型，强转成DataSource
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.notNull(dataSource);
    }


    @Test
    public void testJdbcTemplate() {

        System.out.println("testJdbcTemplate");
        // 从spring容器中取得对象
        // getBean返回值是Object类型，强转成JdbcTemplate
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);
    }

}
