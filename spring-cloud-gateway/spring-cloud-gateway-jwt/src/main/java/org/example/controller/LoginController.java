package org.example.controller;

import org.example.utils.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password) {
        boolean login = "admin".equals(user) && "123456".equals(password);
        if (login) {  //如果验证成功
            Map<String, String> info = new HashMap<>();
            info.put("username", user);
            String token = JwtUtils.createJWT(UUID.randomUUID().toString(), user, null);
            info.put("token", token);
            return token;
        } else {
            return "用户名或密码错误";
        }
    }
}
