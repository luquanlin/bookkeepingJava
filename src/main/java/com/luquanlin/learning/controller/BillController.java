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
    public Map selectVagueBill(String bill_name, String user_name) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectVagueBill(bill_name, user_name);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectBillDetail")
    @ResponseBody
    @ApiOperation(value = "查询账单详情信息", notes = "直接返回数据", httpMethod = "POST")
    public Map selectBillDetail(int bill_id) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectBillDetail(bill_id);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectVagueBillDetail")
    @ResponseBody
    @ApiOperation(value = "模糊查询账单详情信息", notes = "直接返回数据", httpMethod = "POST")
    public Map selectVagueBillDetail(int bill_id, String user_name) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectVagueBillDetail(bill_id, user_name);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectBillsTable")
    @ResponseBody
    @ApiOperation(value = "查询账单列表", notes = "直接返回数据", httpMethod = "POST")
    public Map selectBillsTable(int user_id) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectBillsTable(user_id);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/insertBill")
    @ResponseBody
    @ApiOperation(value = "添加账单", notes = "1：成功，0：失败", httpMethod = "POST")
    public Map insertBill(int user_id, String bill_name, String bill_date) {
        Map result = new HashMap();
        if (billService.insertBill(user_id, bill_name, bill_date)) {
            List<HashMap> bill = billService.selectMaxBillId();
            result.put("bill_id", bill);
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/selectAllBdetail")
    @ResponseBody
    @ApiOperation(value = "查询前端用户账单详情", notes = "直接返回数据", httpMethod = "POST")
    public Map selectAllBdetail(int bill_id) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectAllBdetail(bill_id);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectBillAllPeople")
    @ResponseBody
    @ApiOperation(value = "查询账单的人数", notes = "直接返回数据", httpMethod = "POST")
    public Map selectBillAllPeople(int bill_id) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectBillAllPeople(bill_id);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectOtherBills")
    @ResponseBody
    @ApiOperation(value = "查询他人的账单", notes = "直接返回数据", httpMethod = "POST")
    public Map selectOtherBills(int buuser_id, int buser_id) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectOtherBills(buuser_id, buser_id);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectMyBills")
    @ResponseBody
    @ApiOperation(value = "查询自己的账单", notes = "直接返回数据", httpMethod = "POST")
    public Map selectMyBills(int buuser_id, int buser_id) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectMyBills(buuser_id, buser_id);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/selectAddBill")
    @ResponseBody
    @ApiOperation(value = "查询已结算的账单", notes = "直接返回数据", httpMethod = "POST")
    public Map selectAddBill(int user_id) {
        Map result = new HashMap();
        List<HashMap> bills = billService.selectAddBill(user_id);
        result.put("data", bills);
        return result;
    }

    @RequestMapping("/insertBillPeople")
    @ResponseBody
    @ApiOperation(value = "邀请人加入账单", notes = "1成功，0失败", httpMethod = "POST")
    public Map insertBillPeople(int bill_id, int user_id, String buser_time) {
        Map result = new HashMap();
        if (billService.insertBillPeople(bill_id, user_id, buser_time)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/insertMineBill")
    @ResponseBody
    @ApiOperation(value = "自己加入账单", notes = "1成功，0失败", httpMethod = "POST")
    public Map insertMineBill(int bill_id, int user_id, String buser_time) {
        Map result = new HashMap();
        if (billService.insertMineBill(bill_id, user_id, buser_time)) {

            result.put("data", 1);

        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/deleteBill")
    @ResponseBody
    @ApiOperation(value = "删除账单", notes = "1成功，0失败", httpMethod = "POST")
    public Map deleteBill(int bill_id) {
        Map result = new HashMap();
        if (billService.deleteBill(bill_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/updateBillPeople")
    @ResponseBody
    @ApiOperation(value = "删除账单的人", notes = "1成功，0失败", httpMethod = "POST")
    public Map updateBillPeople(int buser_id) {
        Map result = new HashMap();
        if (billService.updateBillPeople(buser_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }


    @RequestMapping("/sqlQuery")
    @ResponseBody
    @ApiOperation(value = "通用查询", notes = "直接返回数据", httpMethod = "POST")
    public Map sqlQuery(String sql) {
        Map result = new HashMap();
        List<HashMap> sqlQuery = billService.sqlQuery(sql);
        result.put("data", sqlQuery);
        return result;
    }

    @RequestMapping("/billUserIfZero")
    @ResponseBody
    @ApiOperation(value = "查询账单邀请信息", notes = "直接返回数据", httpMethod = "POST")
    public Map billUserIfZero(int user_id) {
        Map result = new HashMap();
        List<HashMap> billUser = billService.billUserIfZero(user_id);
        result.put("data", billUser);
        return result;
    }

    @RequestMapping("/updateBillUserIfOne")
    @ResponseBody
    @ApiOperation(value = "同意账单的邀请", notes = "1成功，0失败", httpMethod = "POST")
    public Map updateBillUserIfOne(int buser_id) {
        Map result = new HashMap();
        if (billService.updateBillUserIfOne(buser_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }


    @RequestMapping("/updateBillUserIfTwo")
    @ResponseBody
    @ApiOperation(value = "拒绝账单的邀请", notes = "1成功，0失败", httpMethod = "POST")
    public Map updateBillUserIfTwo(int buser_id) {
        Map result = new HashMap();
        if (billService.updateBillUserIfTwo(buser_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/insertUserBdetail")
    @ResponseBody
    @ApiOperation(value = "插入账单的详情", notes = "1成功，0失败", httpMethod = "POST")
    public Map insertUserBdetail(int bill_id, int user_id, int type_id, String bdetail_money, String bdetail_remarks, String bdetail_date) {
        Map result = new HashMap();
        if (billService.insertUserBdetail(bill_id, user_id, type_id, bdetail_money, bdetail_remarks, bdetail_date)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }


    @RequestMapping("/deleteUserBdetail")
    @ResponseBody
    @ApiOperation(value = "删除账单的详情", notes = "1成功，0失败", httpMethod = "POST")
    public Map deleteUserBdetail(int bdetail_id) {
        Map result = new HashMap();
        if (billService.deleteUserBdetail(bdetail_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/closeBill")
    @ResponseBody
    @ApiOperation(value = "结算账单", notes = "1成功，0失败", httpMethod = "POST")
    public Map closeBill(int bill_id) {
        Map result = new HashMap();
        if (billService.closeBill(bill_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }


    @RequestMapping("/tjAll")
    @ResponseBody
    @ApiOperation(value = "统计全部", notes = "直接返回数据", httpMethod = "POST")
    public Map tjAll(int user_id) {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjAll(user_id);
        result.put("data", billUser);
        return result;
    }

    @RequestMapping("/tjMarkZero")
    @ResponseBody
    @ApiOperation(value = "统计支出", notes = "直接返回数据", httpMethod = "POST")
    public Map tjMarkZero(int user_id) {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjMarkZero(user_id);
        result.put("data", billUser);
        return result;
    }

    @RequestMapping("/tjMarkOne")
    @ResponseBody
    @ApiOperation(value = "统计收入", notes = "直接返回数据", httpMethod = "POST")
    public Map tjMarkOne(int user_id) {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjMarkOne(user_id);
        result.put("data", billUser);
        return result;
    }


    @RequestMapping("/tjAllHt")
    @ResponseBody
    @ApiOperation(value = "统计后台全部", notes = "直接返回数据", httpMethod = "POST")
    public Map tjAllHt() {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjAllHt();
        result.put("data", billUser);
        return result;
    }

    @RequestMapping("/tjMarkZeroHt")
    @ResponseBody
    @ApiOperation(value = "统计后台支出", notes = "直接返回数据", httpMethod = "POST")
    public Map tjMarkZeroHt() {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjMarkZeroHt();
        result.put("data", billUser);
        return result;
    }

    @RequestMapping("/tjMarkOneHt")
    @ResponseBody
    @ApiOperation(value = "统计后台收入", notes = "直接返回数据", httpMethod = "POST")
    public Map tjMarkOneHt() {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjMarkOneHt();
        result.put("data", billUser);
        return result;
    }

    @RequestMapping("/tjMonthZeroHt")
    @ResponseBody
    @ApiOperation(value = "统计后台y月支出", notes = "直接返回数据", httpMethod = "POST")
    public Map tjMonthZeroHt() {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjMonthZeroHt();
        result.put("data", billUser);
        return result;
    }

    @RequestMapping("/tjMonthOneHt")
    @ResponseBody
    @ApiOperation(value = "统计后台月收入", notes = "直接返回数据", httpMethod = "POST")
    public Map tjMonthOneHt() {
        Map result = new HashMap();
        List<HashMap> billUser = billService.tjMonthOneHt();
        result.put("data", billUser);
        return result;
    }
}
