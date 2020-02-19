package com.luquanlin.learning.controller;

import com.luquanlin.learning.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2020/1/20 0:17
 * @VERSION: 1.0
 **/
@Controller
@RequestMapping("/Bill")
@Api(description = "账单接口")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping("/selectAllBill")
    @ResponseBody
    @ApiOperation(value = "查询所有账单信息", notes = "直接返回数据", httpMethod = "POST")
    public Map selectAllBill() {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectAllBill();
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectVagueBill")
    @ResponseBody
    @ApiOperation(value = "模糊查询账单信息", notes = "直接返回数据", httpMethod = "POST")
    public Map selectVagueBill(String bill_name, String user_name){
        Map result = new HashMap();
        List<HashMap> bills = billService.selectVagueBill(bill_name, user_name);
        result.put("data", bills);
        return result;
    }


}
