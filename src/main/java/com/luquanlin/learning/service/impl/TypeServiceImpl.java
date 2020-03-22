package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Type;
import com.luquanlin.learning.mapper.TypeMapper;
import com.luquanlin.learning.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2020/1/20 0:13
 * @VERSION: 1.0
 **/

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> selectAllType() {
        return typeMapper.selectAllType();
    }

    @Override
    public List<Type> selectVagueType(Type type) {
        return typeMapper.selectVagueType(type);
    }

    @Override
    public boolean updateTypeState(int type_id) {
        int result = typeMapper.updateTypeState(type_id);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insertType(String type_name, String type_mark) {
        int result = typeMapper.insertType(type_name, type_mark);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateType(String type_name, String type_mark, int type_id) {
        int result = typeMapper.updateType(type_name, type_mark, type_id);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap> selectTypeMark(String type_mark) {
        return typeMapper.selectTypeMark(type_mark);
    }
}
