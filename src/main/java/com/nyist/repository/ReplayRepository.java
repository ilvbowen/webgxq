package com.nyist.repository;

import com.nyist.entity.Replay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lvbowen on 2017/4/3.
 */
public interface ReplayRepository extends PagingAndSortingRepository<Replay,Integer> {

    Page<Replay> findByFatherId(Integer fatherId, Pageable pageable);

}
