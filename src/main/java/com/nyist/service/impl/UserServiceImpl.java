package com.nyist.service.impl;

import com.nyist.entity.Plan;
import com.nyist.entity.User;
import com.nyist.repository.UserRepository;
import com.nyist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kingcos on 05/02/2017.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public User userSignUp(User user) {
        if (repository.findByMobilePhone(user.getMobilePhone()) != null) {
            return null;
        }
        return repository.save(user);
    }

    @Override
    @Transactional
    public User userSignIn(User user) {
        User newUser = repository.findByMobilePhone(user.getMobilePhone());
        if (newUser == null || !(newUser.getPassword().equals(user.getPassword()))) {
            newUser = null;
        }
        return newUser;
    }

    @Override
    @Transactional
    public User userUpdate(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public Page<User> userFind(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User userFindByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }
}
