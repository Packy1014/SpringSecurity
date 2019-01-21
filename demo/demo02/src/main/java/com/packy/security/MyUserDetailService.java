package com.packy.security;

import com.packy.mapper.UserMapper;
import com.packy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(userName);
        user.setAuthorities(
                userMapper.findPermissionByUsername(userName)
                        .stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermTag()))
                        .collect(Collectors.toList())
        );
        System.out.println(user);
        return user;
    }
}
