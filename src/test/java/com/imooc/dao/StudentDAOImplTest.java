package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.List;

@RunWith(BlockJUnit4ClassRunner.class)
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
        // students是个List 不是数组
        // System.out.println(Arrays.toString(students));
        System.out.println(students);
    }

    @Test
    public void testSave() {

        StudentDAO studentDAO = new StudentDAOImpl();

        // 构建一个学生对象
        Student student = new Student();

        // 设置学生信息
        student.setName("new20190107");
        student.setAge(40);

        // 存储
        studentDAO.save(student);
    }

}
