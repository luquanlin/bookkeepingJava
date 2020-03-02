package com.luquanlin.learning.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2020/1/20 0:10
 * @VERSION: 1.0
 **/
@Repository
public interface BillMapper {
    List<HashMap> selectAllBill();

    List<HashMap> selectVagueBill(String bill_name, String user_name);

    List<HashMap> selectBillDetail(int bill_id);

    List<HashMap> selectVagueBillDetail(int bill_id, String user_name);

    List<HashMap> selectBillsTable(int user_id);

    List<HashMap> sqlQuery(String sql);

    List<HashMap> selectAllBdetail(int bill_id);

    List<HashMap> sselectBillAllPeople(int bill_id);

    List<HashMap> selectOtherBills(int buuser_id, int buser_id);

    List<HashMap> selectMyBills(int buuser_id, int buser_id);

    List<HashMap> selectAddBill(int user_id);


    int insertBill(int user_id, String bill_name, String bill_date);

    int insertBillPeople(int bill_id, int user_id, String buser_time);
}
