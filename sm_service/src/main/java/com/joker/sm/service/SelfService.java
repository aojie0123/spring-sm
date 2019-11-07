package com.joker.sm.service;

import com.joker.sm.entity.Staff;

public interface SelfService {
    Staff login(String account, String password);
    void changePassword(Integer id, String password);
}