package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.Repository;

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
 *
 * 2）如果我们定义的接口EmployeeRepository extends Repository
 *
 * 如果我们自己的接口没有extends Repository，运行时会报错：
 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springdata
 * .repository.EmployeeRepository' available
 *
 * 3) 添加注解能到达到不用extends Repository的功能
 * @RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
 * */

/*
* 关于 spring data的博客:
*   https://www.cnblogs.com/fzng/p/7253149.html
*   https://www.cnblogs.com/simazilin/p/5645947.html
* */
public interface EmployeeRepository extends Repository<Employee, Integer> {
    // 方法名有一定的规则来书写的，才能工作
    public Employee findByName(String name);
}
