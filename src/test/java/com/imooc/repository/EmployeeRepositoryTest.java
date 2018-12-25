package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// import org.junit.jupiter.api.Test;
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup() {

        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        // 从上下文中取出对象 从容器中取出对象
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {

        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName() {

        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id:" + employee.getId() + " , name:" + employee.getName() + " ,age:" + employee.getAge());
    }

}
