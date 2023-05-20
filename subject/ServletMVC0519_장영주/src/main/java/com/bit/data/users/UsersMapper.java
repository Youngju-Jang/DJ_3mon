package com.bit.data.users;

import com.bit.domain.users.vo.User;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
     User selectUser(@Param("name") String name);
     Boolean checkName(String name);
     void createUser(User user);
}
