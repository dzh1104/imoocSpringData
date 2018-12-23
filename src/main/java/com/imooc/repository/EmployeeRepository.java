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
public interface EmployeeRepository extends Repository<Employee, Integer> {
    // 方法名有一定的规则来书写的，才能工作
    public Employee findByName(String name);
}
