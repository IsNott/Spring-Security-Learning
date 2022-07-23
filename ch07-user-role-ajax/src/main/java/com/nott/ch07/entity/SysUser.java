package com.nott.ch07.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
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
}
