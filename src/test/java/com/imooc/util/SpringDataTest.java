package com.imooc.util;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {
private ApplicationContext ctx = null;
private EmployeeRepository employeeRepository = null;

@Before
public void setup(){
    ctx = new ClassPathXmlApplicationContext("beans-new.xml");
    employeeRepository = ctx.getBean(EmployeeRepository.class);
    System.out.println("setup");
}

@After
public void tearDown(){
    ctx = null;
    System.out.println("tearDown");
}

@Test
public void testEntityManagerFactory() {

}

@Test
public void testGetEmployeeByMaxId() {
    
    Employee employee = employeeRepository.getEmployeeByMaxId();
    System.out.println("id最大的员工信息：" + employee);
}
}
