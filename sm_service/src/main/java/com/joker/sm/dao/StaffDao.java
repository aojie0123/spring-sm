package com.joker.sm.dao;

import com.joker.sm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffDao")
public interface StaffDao {
    void insert(Staff staff);
    void delete(int id);
    void update(Staff staff);
    Staff select(int id);
    List<Staff> selectAll();
}
