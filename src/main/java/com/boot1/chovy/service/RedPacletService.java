package com.boot1.chovy.service;


import com.boot1.chovy.entity.RedPacket;

/**
 * Created by wangchaohui on 2018/10/9.
 */
public interface RedPacletService {
    /**
     * ��ȡ���
     *
     * @param id �������
     * @return �����Ϣ
     */
    public RedPacket getRedPacket(Long id);

    /**
     * �ۼ����
     *
     * @param id�������
     * @return Ӱ������.
     */
    public int decreaseRedPacket(Long id);

}
