package com.bit.domain.users.service;

import com.bit.domain.users.vo.User;

public interface UserService {
     void createUser(User user);
     public User selectUser(String name);
     public boolean checkName(String name);
}
