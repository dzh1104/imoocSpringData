package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentDAOSpringJdbcImplTest {

    // 使用spring开发，会存在一个ApplicationContext类型的对象，保存着上下文的信息
    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        // 从spring容器中取得对象
        studentDAO = (StudentDAO)ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testQuery() {
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " , name:" + student.getName()
                    + ", age:" + student.getAge());
        }

    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("spring-jdbc");
        student.setAge(42);

        studentDAO.save(student);
    }


}
