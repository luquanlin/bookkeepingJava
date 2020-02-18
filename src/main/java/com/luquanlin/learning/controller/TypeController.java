package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.Type;
import com.luquanlin.learning.service.TypeService;
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
@RequestMapping("/Type")
@Api(description = "类别接口")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/selectAllType")
    @ResponseBody
    @ApiOperation(value = "查询所有信息", notes = "直接返回数据", httpMethod = "POST")
    public Map selectAllType() {
        Map result = new HashMap();
        List<Type> typeAll = typeService.selectAllType();
        result.put("data", typeAll);
        return result;
    }

    @RequestMapping("/selectVagueType")
    @ResponseBody
    @ApiOperation(value = "类别模糊查询接口", notes = "直接返回数据", httpMethod = "POST")
    public Map selectVagueType(String type_name, String type_mark) {
        Map result = new HashMap();
        Type type = new Type();
        type.setType_name(type_name);
        type.setType_mark(type_mark);
        List<Type> typeVague = typeService.selectVagueType(type);
        result.put("data", typeVague);
        return result;
    }

    @RequestMapping("/updateTypeState")
    @ResponseBody
    @ApiOperation(value = "删除类别", notes = "1：成功，0：失败", httpMethod = "POST")
    public Map updateTypeState(int type_id) {
        Map result = new HashMap();
        if (typeService.updateTypeState(type_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/insertType")
    @ResponseBody
    @ApiOperation(value = "添加类别", notes = "1：成功，0：失败", httpMethod = "POST")
    public Map insertType(String type_name, String type_mark) {
        Map result = new HashMap();
        if (typeService.insertType(type_name, type_mark)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

    @RequestMapping("/updateType")
    @ResponseBody
    @ApiOperation(value = "修改类别", notes = "1：成功，0：失败", httpMethod = "POST")
    public Map updateType(String type_name, String type_mark, int type_id) {
        Map result = new HashMap();
        if (typeService.updateType(type_name, type_mark, type_id)) {
            result.put("data", 1);
        } else {
            result.put("data", 0);
        }
        return result;
    }

}
