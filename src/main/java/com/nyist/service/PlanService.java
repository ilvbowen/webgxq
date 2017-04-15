package com.nyist.service;

import com.nyist.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by kingcos on 11/02/2017.
 */
public interface PlanService {
    // 发布
    Plan publishPlan(Plan plan);

    // 更新
    Plan updatePlan(Plan plan);

    // 删除
    boolean deletePlan(Plan plan);

    // 根据类型（默认：INFO）按日期倒序查找
    Page<Plan> selectByType(String type, Pageable pageable);

    // 根据 planId 查找
    Plan selectByPlanId(Integer planId);

    // 根据用户，类型（默认：WORK），日期查找
    Page<Plan> selectByTypeAndUserIdAndDate(String type, Integer userId, String date, Pageable pageable);

    // 根据用户，类型（默认：WORK）查找
    Page<Plan> selectByTypeAndUserId(String type, Integer userId, Pageable pageable);










    // 根据用户查找
    Page<Plan> selectByUserId(String type, Pageable pageable);

    // 根据日期查找
    Page<Plan> selectByDate(String date, Pageable pageable);




}
