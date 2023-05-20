package com.bit.domain.users.dao;

import com.bit.domain.users.vo.User;

public interface UserDao {
     public User selectUser(String name);
     boolean checkName(String name);
     void createUser(User user);
}
