package com.nott.ch08.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author Nott
 * @Date 2022/7/22
 */


@TableName("sys_role")
@Data
@ToString
public class SysRole {
    private Long id;
    private String rolename;
    private String rolememo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolememo() {
        return rolememo;
    }

    public void setRolememo(String rolememo) {
        this.rolememo = rolememo;
    }
}
