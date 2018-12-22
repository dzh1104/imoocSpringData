package com.imooc.dao;

import com.imooc.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOSpringJdbcImpl implements StudentDAO {

    // @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {

        return jdbcTemplate;
    }

    // 构造器注入 Spring Beans and Dependency Injection
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> query() {

        final List<Student> students = new ArrayList<Student>();


        String sql = "select id, name , age from student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                // 局部变量 临时变量
                Student student = new Student();

                // 设置属性
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        });

        return students;
    }

    @Override
    public void save(Student student) {

        String sql = "insert into student(name, age) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge()});
    }

}
