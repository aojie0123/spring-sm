package com.joker.sm.service.impl;

import com.joker.sm.dao.StaffDao;
import com.joker.sm.entity.Staff;
import com.joker.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void add(Staff staff) {
        staff.setWorkTime(new Date());
        staff.setStatus("正常");
        staffDao.insert(staff);
    }

    @Override
    public void delete(int id) {
        staffDao.delete(id);
    }

    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public Staff get(int id) {
        return staffDao.select(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}
