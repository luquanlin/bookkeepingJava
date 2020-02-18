package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2020/1/20 0:10
 * @VERSION: 1.0
 **/
@Repository
public interface TypeMapper {
    List<Type> selectAllType();

    List<Type> selectVagueType(Type type);

    int updateTypeState(int type_id);

    int insertType(String type_name, String type_mark);

    int updateType(String type_name, String type_mark,int type_id);
}
