package com.boot1.chovy.service;

/**
 * Created by wangchaohui on 2018/10/9.
 */
public interface UserRedPacketService {

    /**
     * �����������Ϣ.
     *
     * @param redPacketId ������
     * @param userId      ������û����
     * @return Ӱ���¼��.
     */
    public int grapRedPacket(Long redPacketId, Long userId);

}
