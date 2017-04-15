package com.nyist.controller;

import com.nyist.entity.Replay;
import com.nyist.service.ReplayService;
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
 * Created by lvbowen on 2017/4/3.
 */
@RestController
@RequestMapping("/replay")
public class ReplayController {
    @Autowired
    ReplayService service;

    @GetMapping("/find/{fatherId}")
    public ResultMessage selectReplay(@PathVariable("fatherId") Integer fatherId,
                                      @RequestParam("page") Integer page,
                                      @RequestParam("size") Integer size){
        Sort sort = new Sort(Sort.Direction.ASC,"data");
        Pageable pageable = new PageRequest(page - 1,size);
        Page<Replay> replaies= service.findByFatherId(fatherId,pageable);
        List<Replay> list = replaies.getContent();
        StatusCode statusCode;
        if (list.isEmpty()){
            statusCode = StatusCode.ERR;
        }else {
            statusCode = StatusCode.OK;
        }
        return new ResultMessage(statusCode.getStatusCode(),list);
    }

    @PostMapping("/replay")
    public ResultMessage replayPlan(@RequestBody Replay replay){
        List list = new ArrayList();
        StatusCode statusCode;
        Replay replay1 = service.replayPlan(replay);
        if (replay1 == null){
            statusCode = StatusCode.ERR;
        }else {
            statusCode = StatusCode.OK;
            list.add(replay1);
        }
        return new ResultMessage(statusCode.getStatusCode(),list);
    }
    @GetMapping("/delete")
    public ResultMessage deleteReplay(@RequestBody Replay replay){
        List list = new ArrayList();
        StatusCode statusCode;
        if (service.deleteReplay(replay)){
            statusCode = StatusCode.OK;
            list.add(replay);
        }else {
            statusCode = StatusCode.ERR;
        }
        return new ResultMessage(statusCode.getStatusCode(),list);
    }


}
