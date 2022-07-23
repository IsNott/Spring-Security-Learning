package com.nott.ch06;

import com.nott.ch06.entity.SysUser;
import com.nott.ch06.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@SpringBootApplication
@MapperScan("com.nott.*.mapper")
public class Ch06Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch06Application.class, args);
    }

    @Resource
    private SysUserMapper sysUserMapper;


//    @PostConstruct
//    public void insert() {
//        ArrayList<SysUser> list = new ArrayList<>();
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        SysUser user = new SysUser(null, "nott", "nott", encoder.encode("nott"), true, true, true, true, new Date(), new Date(), null);
//        SysUser user1 = new SysUser(null, "user1", "user", encoder.encode("nott"), true, true, true, true, new Date(), new Date(), null);
//        SysUser user2 = new SysUser(null, "user2", "user", encoder.encode("nott"), true, true, true, true, new Date(), new Date(), null);
//        list.add(user);
//        list.add(user1);
//        list.add(user2);
//        for (SysUser sysUser : list) {
//            sysUserMapper.insert(sysUser);
//            System.out.println("Insert row: " + sysUser);
//        }
//    }

}
