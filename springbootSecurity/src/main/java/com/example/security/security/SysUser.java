package com.example.security.security;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/***
 * 定义用户和角色
 */
@Entity
public class SysUser implements UserDetails{ //实现UserDetails接口我们的用户即为springSecurity所使用的用户

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

    @ManyToMany(cascade = {CascadeType.REFRESH} , fetch = FetchType.EAGER) //配置用户和角色多对多关系
    private List<SysRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //重写getAuthorities方法,将用户角色作为权限
        List<GrantedAuthority> auths = new ArrayList<>();
        //List<SysRole> roles = this

        return null;
    }


    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
