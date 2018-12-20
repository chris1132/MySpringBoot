package com.boot1.chovy.service;


import com.boot1.chovy.entity.RedPacket;

/**
 * Created by wangchaohui on 2018/10/9.
 */
public interface RedPacletService {
    /**
     * 获取红包
     *
     * @param id ——编号
     * @return 红包信息
     */
    public RedPacket getRedPacket(Long id);

    /**
     * 扣减红包
     *
     * @param id——编号
     * @return 影响条数.
     */
    public int decreaseRedPacket(Long id);

}
