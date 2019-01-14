package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository 类，spring data核心类
 *  Repository (继承该类)
 *  RepositoryDefinition  (可使用注解代替上面继承的写法)
 *  Reposotory Query  Specifications  (方法名按着规则编写)
 *  Query  Annotaion  (注解，可写sql语句)
 *  Update/Delete/Transaction  (相关数据库的操作)
 * */

/**
 * Repository Hierarchy  (功能体系图)
 *  CrudRepository  (crud)
 *  PagingAndSortingRepository  (分页排序)
 *  JpaRepository
 *  JpaSpecificationExecutor
 * */

/**
 * 1）Repository是一个空接口，标记接口，没有包含方法声明的接口
 *      是spring data的核心接口
 *
 * 2）如果我们定义的接口EmployeeRepository extends Repository
 *      继承该接口后，我们的接口就会被spring所管理
 *      如果不继承该接口，运行测试用例时会报错！
 *          错误信息：org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.imooc.repository.EmployeeRepository' available
 *          因为没有被纳入spring容器
 *
 * 如果我们自己的接口没有extends Repository，运行时会报错：
 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springdata
 * .repository.EmployeeRepository' available
 *
 * 3) 添加注解能到达到不用extends Repository的功能
 * @RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
 * */

/*
* Repository的子接口
*   CrudRepository: 继承Repository，实现了CRUD相关的方法
*   PagingAndSortingRepository: 继承了CrudRepository，实现了分页排序相关的方法
*   JpaRepository: 继承了PagingAndSortingRepository，实现JPA规范相关的方法
* */

/*
* Repository中查询方法定义规则和使用
*   官网文档：https://docs.spring.io/spring-data/jpa/docs/2.1.3.RELEASE/reference/html/
* */

/*
* @Query注解使用
*   在Repository方法中使用，不需要遵循查询方法命名规则
*   只需要将@Query定义在Repository中的方法之上即可
*   支持命名参数及索引参数的使用
*   支持本地查询
*
*   对于按照方法命名规则来使用的话，有弊端：
*    1）方法名会比较长： 约定大于配置
*    2）对于一些复杂的查询，是很难实现
    
*    @Query

*    事务在Spring data中的使用：
*    1）事务一般是在Service层
*    2）@Query、 @Modifying、@Transactional的综合使用
* */

/*
* 关于 spring data的博客:
*   https://www.cnblogs.com/fzng/p/7253149.html
*   https://www.cnblogs.com/simazilin/p/5645947.html
* */

/***
 * domainClass  表示哪个实体类
 * idClass 标识id
 */
// @RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository extends Repository<Employee, Integer> {
// public interface EmployeeRepository {
    // 方法名有一定的规则来书写的，才能工作
    Employee findByName(String name);

// where name like ?% and age <?
public List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

// where name like %? and age <?
public List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

// where name in (?,?....) or age <?
public List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

// where name in (?,?....) and age <?
public List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer age);

@Query("select o from Employee o where id=(select max(id) from Employee t1)")
public Employee getEmployeeByMaxId();

@Query("select o from Employee o where o.name=?1 and o.age=?2")
public List<Employee> queryParams1(String name, Integer age);

@Query("select o from Employee o where o.name=:name and o.age=:age")
public List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

@Query("select o from Employee o where o.name like %?1%")
public List<Employee> queryLike1(String name);

@Query("select o from Employee o where o.name like %:name%")
public List<Employee> queryLike2(@Param("name") String name);

@Query(nativeQuery = true, value = "select count(1) from employee")
public long getCount();

@Modifying
@Query("update Employee o set o.age = :age where o.id = :id")
public void update(@Param("id") Integer id, @Param("age") Integer age);

}
