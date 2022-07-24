package com.nott.ch08.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Nott
 * @Date 2022/7/22
 */

@Data
@TableName("sys_user")
public class SysUser implements UserDetails {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String realname;
    private String password;
    @TableField("isenable")
    private boolean isEnable;
    @TableField("iscredentials")
    private boolean isCredentials;
    private boolean islock;
    @TableField("isExpired")
    private boolean isExpired;
    private Date createtime;
    private Date logintime;
    @TableField(exist = false)
    private List<GrantedAuthority> authorities;

    public SysUser(Long id, String username, String realname, String password, boolean isEnable, boolean isCredentials, boolean isLocked, boolean isExpired, Date createtime, Date logintime, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.isEnable = isEnable;
        this.isCredentials = isCredentials;
        this.islock = isLocked;
        this.isExpired = isExpired;
        this.createtime = createtime;
        this.logintime = logintime;
        this.authorities = authorities;
    }

    public SysUser() {

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return islock;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentials;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public boolean isCredentials() {
        return isCredentials;
    }

    public void setCredentials(boolean credentials) {
        isCredentials = credentials;
    }

    public boolean isIslock() {
        return islock;
    }

    public void setIslock(boolean islock) {
        this.islock = islock;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
