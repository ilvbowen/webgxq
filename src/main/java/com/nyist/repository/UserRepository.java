package com.nyist.repository;

import com.nyist.entity.Plan;
import com.nyist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by kingcos on 06/02/2017.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    public User findByUserId(Integer userId);
    public User findByMobilePhone(String mobilePhone);
}
