package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ProductMapper {
    Product get(Serializable id);
    // 查询商品时，包含类别信息：连接查询
    Product get2(Serializable id);
    Product get3(Serializable id); // 嵌套查询

    List getByCond(@Param("name") Serializable name,
                   @Param("price") Serializable price);
    List getByName(String name);
    List getByName2(String name);

    int save(Product product);
    int save2(Map map);

    List getList(Product product);
    @Delete("delete from product where id in\n" +
            "<script>" +
            "        <foreach collection=\"array\" item=\"id2\" open=\"(\" close=\")\" separator=\",\">\n" +
            "            #{id2}\n" +
            "        </foreach>" +
            "</script>")
    void delete(Serializable... ids);
    void saveList(List<Product> list);
}
