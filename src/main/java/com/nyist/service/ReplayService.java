package com.nyist.service;

import com.nyist.entity.Replay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by lvbowen on 2017/4/3.
 */
public interface ReplayService {
    //回复
    Replay replayPlan(Replay replay);
    //删除回复
    Boolean deleteReplay(Replay replay);
    //根据父Id查找
    Page<Replay> findByFatherId(Integer fatherId, Pageable pageable);


}
