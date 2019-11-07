package com.joker.sm.dao;

import com.joker.sm.entity.Staff;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {
    Staff selectByAccount(String account);
}
