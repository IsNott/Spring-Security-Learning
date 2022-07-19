package com.nott.ch04.entity;

import lombok.Data;

/**
 * @author Nott
 * @Date 2022/7/19
 */

@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String role;
}
