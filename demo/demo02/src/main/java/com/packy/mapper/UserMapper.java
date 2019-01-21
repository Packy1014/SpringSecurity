package com.packy.mapper;

import com.packy.model.Permission;
import com.packy.model.User;

import java.util.List;

public interface UserMapper {

    User findByUsername(String username);

    List<Permission> findPermissionByUsername(String username);

    void updatePassword(User user);

}
