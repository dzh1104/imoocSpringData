package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDAOImplTest {

    @Test
    public void testQuery() {
        // 多态
        StudentDAO studentDAO = new StudentDAOImpl();
        // 查询学生
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id: " + student.getId() + "name: " + student.getName() + "age: " + student.getAge());
        }
    }

    @Test
    public void testSave() {

        StudentDAO studentDAO = new StudentDAOImpl();

        // 构建一个学生对象
        Student student = new Student();

        // 设置学生信息
        student.setName("test");
        student.setAge(30);

        // 存储
        studentDAO.save(student);
    }

}
