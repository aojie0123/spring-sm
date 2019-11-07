package com.joker.sm.service.impl;

import com.joker.sm.dao.SelfDao;
import com.joker.sm.dao.StaffDao;
import com.joker.sm.entity.Staff;
import com.joker.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service("selfService")
public class SelfServiceImpl implements SelfService {

    @Autowired
    private SelfDao selfDao;
    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if (staff == null) {
            return null;
        }
        if (staff.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
            return staff;
        }
        return null;
    }

    @Override
    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.select(id);
        staff.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        staffDao.update(staff);
    }
}
