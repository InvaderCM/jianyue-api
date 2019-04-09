package com.soft1721.jianyue.service.impl;

import com.soft1721.jianyue.entity.User;
import com.soft1721.jianyue.entity.dto.UserDTO;
import com.soft1721.jianyue.service.UserService;
import com.soft1721.jianyue.util.StatusConst;
import com.soft1721.jianyue.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void signIn() {
        UserDTO loginUser = new UserDTO();
        loginUser.setMobile("17805116182");
        String base64Pass = StringUtil.getBase64Encoder("123");
        loginUser.setPassword(base64Pass);
        int status = userService.signIn(loginUser);
        assertEquals(StatusConst.SUCCESS, status);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setMobile("17805116188");
        String password = StringUtil.getBase64Encoder("123");
        user.setPassword(password);
        user.setNickname("LHF");
        user.setStatus((short) 1);
        user.setAvatar("http://www.gx8899.com/uploads/allimg/160822/3-160R20Z026-lp.jpg");
        userService.insert(user);
    }

    @Test
    public void getUserByMobile() {
        User user = userService.getUserByMobile("17805116182");
        System.out.println(user);
    }

    @Test
    public void getUserById() {
        User user = userService.getUserById(8);
        System.out.println(user);
    }


//    @Test
//    public void updateNickName() {
//        User user = userService.getUserById(18);
//        String nickname = "lihuofang";
//        user.setNickname(nickname);
//        userService.updateNickName(user);
//    }

    @Test
    public void updatePassword() {
    }

    @Test
    public void insertDto() {
        User user = new User();
        user.setMobile("17805116122");
        String password = StringUtil.getBase64Encoder("123");
        user.setPassword(password);
        user.setNickname("zhanxin");
        user.setStatus((short) 1);
        user.setAvatar("http://www.gx8899.com/uploads/allimg/160822/3-160R20Z026-lp.jpg");
        userService.insert(user);
    }
}