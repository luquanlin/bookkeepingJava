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

    List<HashMap> selectVagueBill(String bill_name,String user_name);
}
