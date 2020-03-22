package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.Type;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2020/1/20 0:12
 * @VERSION: 1.0
 **/
public interface TypeService {
    List<Type> selectAllType();

    List<Type> selectVagueType(Type type);

    boolean updateTypeState(int type_id);

    boolean insertType(String type_name, String type_mark);

    boolean updateType(String type_name, String type_mark,int type_id);

    List<HashMap> selectTypeMark(String type_mark);

}
