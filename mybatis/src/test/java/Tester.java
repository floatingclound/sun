import com.bjpowernode.mapper.ProductMapper;
import com.bjpowernode.mapper.TypeMapper;
import com.bjpowernode.pojo.Product;
import com.bjpowernode.pojo.Type;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tester {

    @Test
    public void test01() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 执行命名空间为product中id为get的标签中的SQL，并将50作为条件进行查询
        Product product = session.selectOne("product.get", 50);
        session.close(); // 将连接返回到连接池对象中

        System.out.println(product);
    }

    @Test
    public void test02() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 执行命名空间为product中id为save的标签中的SQL，并将 product对象 作为条件
        Product product = new Product();
        product.setName("野兽");
        product.setPrice("888");
        session.insert("product.save", product);

        MyBatisUtils.commit(); // 提交事务
        MyBatisUtils.release(); // 释放资源

    }

    @Test
    public void test03() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 使用MyBatis创建指定接口的实现类
        ProductMapper productMapper = session.getMapper(ProductMapper.class);
        Product product = productMapper.get(50);
        System.out.println(product);
        MyBatisUtils.release(); // 释放资源

    }

    @Test
    public void test04() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 执行命名空间为product中id为save的标签中的SQL，并将 product对象 作为条件
        Product product = new Product();
        product.setName("野兽2");
        product.setPrice("18888");
        ProductMapper productMapper = session.getMapper(ProductMapper.class);
        productMapper.save(product);

        MyBatisUtils.commit(); // 提交事务
        MyBatisUtils.release(); // 释放资源

    }

    @Test
    public void test05() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 使用MyBatis创建指定接口的实现类
        TypeMapper typeMapper = session.getMapper(TypeMapper.class);
        List list = typeMapper.getAll2();
        System.out.println(list);
        MyBatisUtils.release(); // 释放资源
    }

    @Test
    public void test06() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 执行命名空间为product中id为get的标签中的SQL，并将50作为条件进行查询

        ProductMapper mapper = session.getMapper(ProductMapper.class);
        Product product = mapper.get(50);
        System.out.println(product);

        session.close(); // 将连接返回到连接池对象中

        System.out.println(product);
    }

    @Test
    public void test07() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 执行命名空间为product中id为save的标签中的SQL，并将 product对象 作为条件

        ProductMapper productMapper = session.getMapper(ProductMapper.class);
        productMapper.save2(new HashMap(){{
            put("name", "乒乓");
            put("price", "9.9");
        }});

        MyBatisUtils.commit(); // 提交事务
        MyBatisUtils.release(); // 释放资源

    }

    @Test
    public void test08() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 执行命名空间为product中id为get的标签中的SQL，并将50作为条件进行查询

        ProductMapper mapper = session.getMapper(ProductMapper.class);
        List 乒乓 = mapper.getByCond("乒乓", "9.90");

        session.close(); // 将连接返回到连接池对象中

        System.out.println(乒乓);
    }

    @Test
    public void test09() {
        // 获取连接，操作数据库
        SqlSession session = MyBatisUtils.openSession();
        // 执行命名空间为product中id为get的标签中的SQL，并将50作为条件进行查询

        ProductMapper mapper = session.getMapper(ProductMapper.class);
        String name = "美";
        List list = mapper.getByName2(name);

        session.close(); // 将连接返回到连接池对象中

        System.out.println(list);
    }

    @Test
    public void test10() {
        SqlSession session = MyBatisUtils.openSession();
        ProductMapper productMapper = session.getMapper(ProductMapper.class);

        Product product = new Product();
        product.setName("美");
        product.setDescription("是");
        List list = productMapper.getList(product);
        System.out.println(list);
    }

    @Test
    public void test11() {
        SqlSession session = MyBatisUtils.openSession();
        ProductMapper productMapper = session.getMapper(ProductMapper.class);

        productMapper.delete(new String[] {"69", "70"});

        MyBatisUtils.commit();
    }

    @Test
    public void test12() {
        SqlSession session = MyBatisUtils.openSession();
        ProductMapper productMapper = session.getMapper(ProductMapper.class);
        List list = new ArrayList();
        Product product1 = new Product();
        product1.setName("a");
        Product product2 = new Product();
        product2.setName("b");

        list.add(product1);
        list.add(product2);

        productMapper.saveList(list);

        MyBatisUtils.commit();
    }

    @Test
    public void test13() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        Type type = typeMapper.get("1");
        System.out.println(type);
    }

    @Test
    public void test14() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.get2(50);
        System.out.println(product);
    }

    @Test
    public void test15() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        Type type = typeMapper.get2("1");
        System.out.println(type);
    }

    @Test
    public void test16() {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.get(50);
        Product product2 = productMapper.get(50);
        System.out.println(product == product2);
        sqlSession.close();
        /*Type type = product.getType();
        System.out.println(product);
        System.out.println(type);*/
    }

    @Test
    public void test17() {
        SqlSession sqlSession = null;
        ProductMapper productMapper = null;

        sqlSession = MyBatisUtils.openSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.get(50);
        MyBatisUtils.release(); // 会话过程中查询的数据将会被序列化到磁盘中作为二级缓存

        sqlSession = MyBatisUtils.openSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        productMapper.delete(74);
        Product product2 = productMapper.get(50);
        Product product3 = productMapper.get(50);
        System.out.println(product2 == product3);
        MyBatisUtils.release();

    }

    @Test
    public void test18() {
        SqlSession sqlSession = null;
        ProductMapper productMapper = null;

        sqlSession = MyBatisUtils.openSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.get2(50);
        MyBatisUtils.release(); // 会话过程中查询的数据将会被序列化到磁盘中作为二级缓存

        sqlSession = MyBatisUtils.openSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        typeMapper.update("2", "电脑办公222");
        Product product2 = productMapper.get2(50);
        MyBatisUtils.commit();
        MyBatisUtils.release();

        System.out.println(product);
        System.out.println(product2);

    }
}
