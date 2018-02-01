package com.boot1.chovy.service;

/**
 * Created by wangchaohui on 2018/2/1.
 */

@FunctionalInterface
public interface ListTurnInterface<F,T> {

    T concert(F f);
}
