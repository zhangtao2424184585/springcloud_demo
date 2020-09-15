package com.example.demo.configer;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDetail
 * @Description TODO
 * @Date 2020/8/27 15:22
 * @Created by zhangtao
 */
@Service("userDetailsService")
public class UserDetail implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        User userDetail = new User("zhangtao","123", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        return userDetail;
    }
}
