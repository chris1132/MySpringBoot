package com.boot1.chovy.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by wangchaohui on 2018/10/9.
 *
 * @Description: �û��������
 */
public class UserRedPacket implements Serializable {

    private static final long serialVersionUID = -4254139761089137269L;
    // �û����id
    private Long id;
    // ���id
    private Long redPacketId;
    // ��������û���id
    private Long userId;
    // ��������
    private Double amount;
    // �����ʱ��
    private Timestamp grabTime;
    // ��ע
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRedPacketId() {
        return redPacketId;
    }

    public void setRedPacketId(Long redPacketId) {
        this.redPacketId = redPacketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getGrabTime() {
        return grabTime;
    }

    public void setGrabTime(Timestamp grabTime) {
        this.grabTime = grabTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
