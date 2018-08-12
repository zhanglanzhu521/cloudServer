package com.hellowood.dynamicdatasource.mapper;

import com.hellowood.dynamicdatasource.modal.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Title :DAO
 * @Description :DAO
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
//@Mapper
public interface ProductDao {
    @Select("SELECT *  FROM product        WHERE id = #{id}        LIMIT 1")
    Product select(@Param("id") long id);

    @Update("UPDATE product SET name = #{name}, price = #{price}  WHERE id = #{id}  LIMIT 1")
    Integer update(Product product);

    @Insert("INSERT INTO product (name, price) VALUES (#{name}, #{price});")
    Integer insert(Product product);

    @Delete("DELETE FROM product WHERE id = #{id} LIMIT 1")
    Integer delete(long productId);

    @Select("SELECT * FROM product")
    List<Product> getAllProduct();
}
