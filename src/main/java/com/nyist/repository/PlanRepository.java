package com.nyist.repository;

import com.nyist.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by kingcos on 11/02/2017.
 */
public interface PlanRepository extends PagingAndSortingRepository<Plan, Integer> {
    Page<Plan> findByType(String type, Pageable pageable);
    Plan findByPlanId(Integer planId);
    Page<Plan> findByTypeAndUserId(String type, Integer userId, Pageable pageable);
    Page<Plan> findByTypeAndUserIdAndDate(String type, Integer userId, String date, Pageable pageable);







    Page<Plan> findByUserId(String userId, Pageable pageable);
    Page<Plan> findByDate(String date, Pageable pageable);





}
