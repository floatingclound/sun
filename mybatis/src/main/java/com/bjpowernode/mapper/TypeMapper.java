package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Type;

import java.io.Serializable;
import java.util.List;

public interface TypeMapper {
    List getAll();
    List<Type> getAll2();
    Type get(String id); // 连接查询
    Type get2(Serializable id); // 嵌套查询

    void update(String id, String name);
}
