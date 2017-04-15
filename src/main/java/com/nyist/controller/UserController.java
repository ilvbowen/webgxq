package com.nyist.controller;

import com.nyist.entity.User;
import com.nyist.service.UserService;
import com.nyist.utility.MD5Util;
import com.nyist.utility.ResultMessage;
import com.nyist.utility.StatusCode;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sun.security.rsa.RSASignature;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingcos on 05/02/2017.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/sign/up")
    public ResultMessage userSignUp(@RequestParam("userName") String userName,
                                    @RequestParam("mobilePhone") String mobilePhone,
                                    @RequestParam("password") String password) {
        List<User> list = new ArrayList<>();
//        password = MD5Util.encode(password);
        User newUser = service.userSignUp(new User(userName, mobilePhone, password));
        StatusCode status;
        if (newUser == null) {
            status = StatusCode.ERR;
        } else {
            list.add(newUser);
            status = StatusCode.OK;
        }
        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/sign/in")
    public ResultMessage userSignIn(@RequestParam("mobilePhone") String mobilePhone,
                                    @RequestParam("password") String password) {
        List<User> list = new ArrayList<>();
//        password = MD5Util.encode(password);
        User newUser = service.userSignIn(new User(mobilePhone, password));
        StatusCode status;

        if (newUser == null) {
            status = StatusCode.ERR;
        } else {
            list.add(newUser);
            status = StatusCode.OK;
        }

        return new ResultMessage(status.getStatusCode(), list);
    }

    @PutMapping(value = "/update")
    public ResultMessage userUpdate(@RequestBody User user) {
        List<User> list = new ArrayList<>();
        User newUser = service.userUpdate(user);
        StatusCode status;

        if (newUser == null) {
            status = StatusCode.ERR;
        } else {
            list.add(newUser);
            status = StatusCode.OK;
        }
        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/find/{size}")
    public ResultMessage userFind(@PathVariable("size") Integer size,
                                  @RequestParam(value = "page") Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "userLevel");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<User> users = service.userFind(pageable);
        List<User> list = users.getContent();

        StatusCode status;

        if (list.size() == 0) {
            status = StatusCode.ERR;
        } else {
            status = StatusCode.OK;
        }
        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/find")
    public ResultMessage userFindByUserId(@RequestParam(value = "userId") Integer userId) {
        List<User> list = new ArrayList<>();
        User user = service.userFindByUserId(userId);

        StatusCode status;

        if (user == null) {
            status = StatusCode.ERR;
        } else {
            list.add(user);
            status = StatusCode.OK;
        }
        return new ResultMessage(status.getStatusCode(), list);
    }






}
