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
}
