package com.nyist.service;

import com.nyist.entity.Plan;
import com.nyist.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by kingcos on 05/02/2017.
 */

public interface UserService {
    // 注册
    User userSignUp(User User);

    // 登录
    User userSignIn(User user);

    // 更新
    User userUpdate(User user);

    // 查找
    Page<User> userFind(Pageable pageable);

    // 按 UserId 查找
    User userFindByUserId(Integer userId);

    // 删除



    // 按等级查找

    // 按备注查找
}
