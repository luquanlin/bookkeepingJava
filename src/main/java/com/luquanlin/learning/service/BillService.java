package com.luquanlin.learning.service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/11/3 22:11
 * @VERSION: 1.0
 **/
public interface BillService {
    List<HashMap> selectAllBill();

    List<HashMap> selectVagueBill(String bill_name, String user_name);

    List<HashMap> selectBillDetail(int bill_id);

    List<HashMap> selectVagueBillDetail(int bill_id, String user_name);

    List<HashMap> selectBillsTable(int user_id);

    boolean insertBill(int user_id, String bill_name, String bill_date);

    List<HashMap> selectAllBdetail(int bill_id);

    List<HashMap> selectBillAllPeople(int bill_id);

    List<HashMap> selectOtherBills(int buuser_id, int buser_id);

    List<HashMap> selectMyBills(int buuser_id, int buser_id);

    List<HashMap> selectAddBill(int user_id);

    boolean insertBillPeople(int bill_id, int user_id, String buser_time);

    List<HashMap> selectMaxBillId();

    boolean insertMineBill(int bill_id, int user_id, String buser_time);

    boolean deleteBill(int bill_id);

    boolean updateBillPeople(int buser_id);

    List<HashMap> billUserIfZero(int user_id);

    List<HashMap> sqlQuery(String sql);

    boolean updateBillUserIfOne(int buser_id);

    boolean updateBillUserIfTwo(int buser_id);

    boolean insertUserBdetail(int bill_id, int user_id, int type_id, String bdetail_money, String bdetail_remarks, String bdetail_date);

    boolean deleteUserBdetail(int bdetail_id);
}
