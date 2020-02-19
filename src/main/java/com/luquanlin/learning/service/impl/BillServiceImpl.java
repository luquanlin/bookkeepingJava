package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.mapper.BillMapper;
import com.luquanlin.learning.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/11/3 22:12
 * @VERSION: 1.0
 **/
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;

    @Override
    public List<HashMap> selectAllBill() {
        return billMapper.selectAllBill();
    }

    @Override
    public List<HashMap> selectVagueBill(String bill_name, String user_name) {
        return billMapper.selectVagueBill(bill_name, user_name);
    }
}
