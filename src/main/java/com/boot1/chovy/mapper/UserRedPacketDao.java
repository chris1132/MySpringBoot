package com.boot1.chovy.mapper;

import com.boot1.chovy.entity.UserRedPacket;
import org.springframework.stereotype.Repository;

/**
 * Created by wangchaohui on 2018/10/9.
 */
@Repository
public interface UserRedPacketDao {

    /**
     * �����������Ϣ.
     *
     * @param userRedPacket �����������Ϣ
     * @return Ӱ���¼��.
     */
    public int grapRedPacket(UserRedPacket userRedPacket);
}
