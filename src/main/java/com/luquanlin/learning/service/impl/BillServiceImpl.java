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

    @Override
    public List<HashMap> selectBillDetail(int bill_id) {
        return billMapper.selectBillDetail(bill_id);
    }

    @Override
    public List<HashMap> selectVagueBillDetail(int bill_id, String user_name) {
        return billMapper.selectVagueBillDetail(bill_id, user_name);
    }

    @Override
    public List<HashMap> selectBillsTable(int user_id) {
        return billMapper.selectBillsTable(user_id);
    }

    @Override
    public boolean insertBill(int user_id, String bill_name, String bill_date) {
        int result = billMapper.insertBill(user_id, bill_name, bill_date);
        if (result > 0) {
            return true;
        }
        return false;
    }


    @Override
    public List<HashMap> selectAllBdetail(int bill_id) {
        return billMapper.selectAllBdetail(bill_id);
    }

    @Override
    public List<HashMap> selectBillAllPeople(int bill_id) {
        return billMapper.selectBillAllPeople(bill_id);
    }

    @Override
    public List<HashMap> selectOtherBills(int buuser_id, int buser_id) {
        return billMapper.selectOtherBills(buuser_id, buser_id);
    }

    @Override
    public List<HashMap> selectMyBills(int buuser_id, int buser_id) {
        return billMapper.selectMyBills(buuser_id, buser_id);
    }

    @Override
    public List<HashMap> selectAddBill(int user_id) {
        return billMapper.selectAddBill(user_id);
    }

    @Override
    public boolean insertBillPeople(int bill_id, int user_id, String buser_time) {
        int result = billMapper.insertBillPeople(bill_id, user_id, buser_time);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap> selectMaxBillId() {
        return billMapper.selectMaxBillId();
    }

    @Override
    public boolean insertMineBill(int bill_id, int user_id, String buser_time) {
        int result = billMapper.insertMineBill(bill_id, user_id, buser_time);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBill(int bill_id) {
        int result = billMapper.deleteBill(bill_id);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBillPeople(int buser_id) {
        int result = billMapper.updateBillPeople(buser_id);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap> billUserIfZero(int user_id) {
        return billMapper.billUserIfZero(user_id);
    }

    @Override
    public List<HashMap> sqlQuery(String sql) {
        return billMapper.sqlQuery(sql);
    }

    @Override
    public boolean updateBillUserIfOne(int buser_id) {
        int result = billMapper.updateBillUserIfOne(buser_id);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBillUserIfTwo(int buser_id) {
        int result = billMapper.updateBillUserIfTwo(buser_id);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
