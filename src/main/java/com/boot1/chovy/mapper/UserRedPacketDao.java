package com.boot1.chovy.mapper;

import com.boot1.chovy.entity.UserRedPacket;
import org.springframework.stereotype.Repository;

/**
 * Created by wangchaohui on 2018/10/9.
 */
@Repository
public interface UserRedPacketDao {

    /**
     * 插入抢红包信息.
     *
     * @param userRedPacket ——抢红包信息
     * @return 影响记录数.
     */
    public int grapRedPacket(UserRedPacket userRedPacket);
}
