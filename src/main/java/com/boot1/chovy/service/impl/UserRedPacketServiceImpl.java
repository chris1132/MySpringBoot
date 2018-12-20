package com.boot1.chovy.service.impl;


import com.boot1.chovy.entity.RedPacket;
import com.boot1.chovy.entity.UserRedPacket;
import com.boot1.chovy.mapper.RedPacketDao;
import com.boot1.chovy.mapper.UserRedPacketDao;
import com.boot1.chovy.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangchaohui on 2018/10/9.
 */
@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired
    private UserRedPacketDao userRedPacketDao;

    @Autowired
    private RedPacketDao redPacketDao;

    // ʧ��
    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId, Long userId) {
        // ��ȡ�����Ϣ
        RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
        int leftRedPacket = redPacket.getStock();
        // ��ǰС���������0
        if (leftRedPacket > 0) {
            redPacketDao.decreaseRedPacket(redPacketId);
            // logger.info("ʣ��Stock����:{}", leftRedPacket);
            // �����������Ϣ
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("redpacket- " + redPacketId);
            // �����������Ϣ
            int result = userRedPacketDao.grapRedPacket(userRedPacket);
            return result;
        }
        // logger.info("û�к����.....ʣ��Stock����:{}", leftRedPacket);
        // ʧ�ܷ���
        return FAILED;
    }
}
