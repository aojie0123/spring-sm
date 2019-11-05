package com.joker.sm.dao;

import com.joker.sm.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(int i);
    void update(Department department);
    Department select(int i);
    List<Department> selectAll();
}
