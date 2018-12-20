package com.boot1.chris.service.impl;

import com.boot1.chris.entity.Girl;
import com.boot1.chris.mapper.GirlMapper;
import com.boot1.chris.service.GirlService;
import com.boot1.config.datasource.mysql.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlMapper girlMapper;

    @DS("chrisDataSource")
    public Girl getGirlById(int id){
        return girlMapper.getGirlById(id);
    }
}
