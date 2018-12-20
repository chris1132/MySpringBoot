package com.boot1.chovy.service.impl;

import com.boot1.chovy.entity.RedPacket;
import com.boot1.chovy.mapper.RedPacketDao;
import com.boot1.chovy.service.RedPacletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangchaohui on 2018/10/9.
 */

@Service
public class RedPacketServiceImpl implements RedPacletService {

    @Autowired
    private RedPacketDao redPacketDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Long id) {
        return redPacketDao.getRedPacket(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Long id) {
        return redPacketDao.decreaseRedPacket(id);
    }
}
