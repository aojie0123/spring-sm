package com.joker.sm.service;

import com.joker.sm.entity.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void delete(int id);
    void update(Staff staff);
    Staff get(int id);
    List<Staff> getAll();
}
