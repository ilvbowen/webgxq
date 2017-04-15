package com.nyist.service.impl;

import com.nyist.entity.Plan;
import com.nyist.repository.PlanRepository;
import com.nyist.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kingcos on 11/02/2017.
 */

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository repository;

    @Override
    @Transactional
    public Plan publishPlan(Plan plan) {
        return repository.save(plan);
    }

    @Override
    public Plan updatePlan(Plan plan) {
        return repository.save(plan);
    }

    @Override
    public boolean deletePlan(Plan plan) {
        if (repository.findByPlanId(plan.getPlanId()) != null) {
            repository.delete(plan);
            return true;
        }
        return false;
    }
    @Override
    public Plan selectByPlanId(Integer planId) {
        return repository.findByPlanId(planId);
    }

    @Override
    public Page<Plan> selectByType(String type, Pageable pageable) {
        return repository.findByType(type, pageable);
    }

    @Override
    public Page<Plan> selectByTypeAndUserId(String type, Integer userId, Pageable pageable) {
        return repository.findByTypeAndUserId(type, userId, pageable);
    }

    @Override
    public Page<Plan> selectByTypeAndUserIdAndDate(String type, Integer userId, String date, Pageable pageable) {
        return repository.findByTypeAndUserIdAndDate(type, userId, date, pageable);
    }








    @Override
    public Page<Plan> selectByUserId(String userId, Pageable pageable) {
        return repository.findByUserId(userId, pageable);
    }

    @Override
    public Page<Plan> selectByDate(String date, Pageable pageable) {
        return repository.findByDate(date, pageable);
    }


}
