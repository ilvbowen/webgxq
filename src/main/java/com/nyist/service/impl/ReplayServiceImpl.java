package com.nyist.service.impl;

import com.nyist.entity.Replay;
import com.nyist.repository.ReplayRepository;
import com.nyist.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by lvbowen on 2017/4/3.
 */
@Service
public class ReplayServiceImpl implements ReplayService {
    @Autowired
    ReplayRepository repository;

    @Override
    public Replay replayPlan(Replay replay) {
        repository.save(replay);
        return null;
    }

    @Override
    public Boolean deleteReplay(Replay replay) {
        if (repository.findOne(replay.getReplayId()) != null){
            repository.delete(replay.getReplayId());
            return true;
        }
        return false;
    }

    @Override
    public Page<Replay> findByFatherId(Integer fatherId, Pageable pageable) {
        return repository.findByFatherId(fatherId,pageable);
    }
}
