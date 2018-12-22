package com.imooc.dao;

import com.imooc.domain.Student;
import com.imooc.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类: 通过最原始的JDBC的方式操作
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> query() {

        List<Student> students = new ArrayList<>();

        // 需要关闭，写在try外面
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;

        // sql语句
        String sql = "select id, name, age from student";
        try {
            connection  = JDBCUtil.getConnection();
            preparedstatement = connection.prepareStatement(sql);
            // 执行查询，得到结果集
            resultset = preparedstatement.executeQuery();

            // 循环迭代，取出结果集中的数据
            while(resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");

                // 局部变量 临时变量
                Student student = new Student();

                // 设置属性
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                // 添加到 students，最后返回
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭 resultset, preparedstatement, connection
            JDBCUtil.release(resultset, preparedstatement, connection);
        }

        // 返回 students
        return students;
    }

    @Override
    public void save(Student student) {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;

        // sql语句 占位符
        String sql = "insert into student(name, age) values(?, ?)";

        try {
            connection  = JDBCUtil.getConnection();
            preparedstatement = connection.prepareStatement(sql);
            // 设置数据，将 学生信息 存储进数据库
            preparedstatement.setString(1, student.getName());
            preparedstatement.setInt(2, student.getAge());

            // 更新
            preparedstatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultset, preparedstatement, connection);
        }
    }
}
