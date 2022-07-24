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

}
