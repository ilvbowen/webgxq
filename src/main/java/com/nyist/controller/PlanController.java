package com.nyist.controller;

import com.nyist.entity.Plan;
import com.nyist.service.PlanService;
import com.nyist.utility.ResultMessage;
import com.nyist.utility.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingcos on 11/02/2017.
 */

@RestController
@RequestMapping(value = "/plan")
public class PlanController {

    @Autowired
    private PlanService service;

    @PostMapping(value = "/publish")
    public ResultMessage planPublish(@RequestBody Plan plan) {
        List<Plan> list = new ArrayList<>();
        Plan newPlan = service.publishPlan(plan);
        StatusCode status;

        if (newPlan == null) {
            status = StatusCode.ERR;
        } else {
            status = StatusCode.OK;
            list.add(newPlan);
        }
        return new ResultMessage(status.getStatusCode(), list);
    }

    @PutMapping(value = "/update")
    public ResultMessage planUpdate(@RequestBody Plan plan) {
        List<Plan> list = new ArrayList<>();
        Plan newPlan = service.updatePlan(plan);
        StatusCode status;

        if (newPlan == null) {
            status = StatusCode.ERR;
        } else {
            status = StatusCode.OK;
            list.add(newPlan);
        }
        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/delete")
    public ResultMessage planDelete(@RequestBody Plan plan) {
        List<Plan> list = new ArrayList<>();
        StatusCode status;

        if (!service.deletePlan(plan)) {
            status = StatusCode.ERR;
        } else {
            status = StatusCode.OK;
        }
        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/find")
    public ResultMessage planFindByPlanId(@RequestParam(value = "planId") Integer planId) {
        List<Plan> list = new ArrayList<>();
        Plan plan = service.selectByPlanId(planId);

        StatusCode status;
        if (plan == null) {
            status = StatusCode.ERR;
        } else {
            list.add(plan);
            status = StatusCode.OK;
        }

        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/find/{type}/{size}")
    public ResultMessage planFindByType(@PathVariable("size") Integer size,
                                        @PathVariable("type") String type,
                                        @RequestParam(value = "page") Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "date", "planId");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<Plan> plans = service.selectByType(type, pageable);
        List<Plan> list = plans.getContent();

        StatusCode status;
        if (list.size() == 0) {
            status = StatusCode.ERR;
        } else {
            status = StatusCode.OK;
        }

        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/find/{type}/{size}/user")
    public ResultMessage planFindByType(@PathVariable("size") Integer size,
                                        @PathVariable("type") String type,
                                        @RequestParam(value = "userId") Integer userId,
                                        @RequestParam(value = "page") Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "date", "planId");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<Plan> plans = service.selectByTypeAndUserId(type, userId, pageable);
        List<Plan> list = plans.getContent();

        StatusCode status;
        if (list.size() == 0) {
            status = StatusCode.ERR;
        } else {
            status = StatusCode.OK;
        }

        return new ResultMessage(status.getStatusCode(), list);
    }

    @PostMapping(value = "/find/{type}/{size}/date_user")
    public ResultMessage planFindByType(@PathVariable("size") Integer size,
                                        @PathVariable("type") String type,
                                        @RequestParam(value = "userId") Integer userId,
                                        @RequestParam(value = "date") String date,
                                        @RequestParam(value = "page") Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "planId");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Page<Plan> plans = service.selectByTypeAndUserIdAndDate(type, userId, date, pageable);
        List<Plan> list = plans.getContent();

        StatusCode status;
        if (list.size() == 0) {
            status = StatusCode.ERR;
        } else {
            status = StatusCode.OK;
        }

        return new ResultMessage(status.getStatusCode(), list);
    }

//    @PostMapping("/find/leaf/{fatherId}")
//    public ResultMessage plainFindByFatherId(@PathVariable("fatherId") Integer fatherId,
//                                             @RequestParam("page") Integer page,
//                                             @RequestParam("size") Integer size){
//        Sort sort = new Sort(Sort.Direction.ASC,"date");
//        Pageable pageable = new PageRequest(page - 1, size,sort);
//        Page<Plan> plans = service.selectByFatherId(fatherId,pageable);
//        List<Plan> list = plans.getContent();
//        StatusCode status;
//        if (list.size() == 0) {
//            status = StatusCode.ERR;
//        } else {
//            status = StatusCode.OK;
//        }
//        return new ResultMessage(status.getStatusCode(), list);
//    }














//    @PostMapping(value = "/find/{size}/user_id")
//    public ResultMessage planFindByUserId(@PathVariable("size") Integer size,
//                                  @RequestParam String userId,
//                                  @RequestParam(value = "page") Integer page) {
//        Pageable pageable = new PageRequest(page - 1, size);
//        Page<Plan> plans = service.selectByUserId(userId, pageable);
//        List<Plan> list = plans.getContent();
//
//        StatusCode status;
//        if (list.size() == 0) {
//            status = StatusCode.ERR;
//        } else {
//            status = StatusCode.OK;
//        }
//
//        return new ResultMessage(status.getStatusCode(), list);
//    }




//    @PostMapping(value = "/find/{size}/")
//    public ResultMessage planFindByType(@PathVariable("size") Integer size,
//                                  @RequestParam(value = "type") String type,
//                                  @RequestParam(value = "userId") Integer userId,
//                                  @RequestParam(value = "page") Integer page) {
//        Sort sort = new Sort(Sort.Direction.DESC, "date");
//        Pageable pageable = new PageRequest(page - 1, size, sort);
//        Page<Plan> plans = service.selectByTypeAndUserId(type, userId, pageable);
//        List<Plan> list = plans.getContent();
//
//        StatusCode status;
//        if (list.size() == 0) {
//            status = StatusCode.ERR;
//        } else {
//            status = StatusCode.OK;
//        }
//
//        return new ResultMessage(status.getStatusCode(), list);
//    }

//    @PostMapping(value = "/find/{size}/date")
//    public ResultMessage planFindByDate(@PathVariable("size") Integer size,
//                                  @RequestParam(value = "date") String date,
//                                  @RequestParam(value = "page") Integer page) {
//        Pageable pageable = new PageRequest(page - 1, size);
//        Page<Plan> plans = service.selectByDate(date, pageable);
//        List<Plan> list = plans.getContent();
//
//        StatusCode status;
//        if (list.size() == 0) {
//            status = StatusCode.ERR;
//        } else {
//            status = StatusCode.OK;
//        }
//
//        return new ResultMessage(status.getStatusCode(), list);
//    }

}
