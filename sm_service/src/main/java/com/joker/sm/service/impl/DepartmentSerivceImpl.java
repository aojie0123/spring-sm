package com.joker.sm.service.impl;

import com.joker.sm.dao.DepartmentDao;
import com.joker.sm.entity.Department;
import com.joker.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentSerivce")
public class DepartmentSerivceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void add(Department department) {
        departmentDao.insert(department);
    }

    @Override
    public void delete(int id) {
        departmentDao.delete(id);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public Department get(int id) {
        return departmentDao.select(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
