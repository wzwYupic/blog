package com.whpu.springbootshirojwt.controller;



import com.whpu.springbootshirojwt.common.lang.Result;
import com.whpu.springbootshirojwt.entity.User;
import com.whpu.springbootshirojwt.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1L);
        return Result.succ(user);
    }

    /**
     * @Validated 校验实体类规则 @NotBlank、@Email
     * @RequestBody 的作用其实是将json格式的数据转为java对象。
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {
        return Result.succ(user);
    }

}
