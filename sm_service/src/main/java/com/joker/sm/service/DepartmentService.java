package com.joker.sm.service;

import com.joker.sm.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void delete(int id);
    void update(Department department);
    Department get(int id);
    List<Department> getAll();
}
