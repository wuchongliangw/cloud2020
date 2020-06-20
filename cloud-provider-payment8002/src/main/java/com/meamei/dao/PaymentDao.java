package com.meamei.dao;

import com.meamei.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author mm013
 * @create 2020-06-19 11:31:33
 * @description:
 */
@Mapper
public interface PaymentDao {

    @Insert("insert into payment(serial) values(#{serial});")
    int create(Payment payment);

    @Select("select * from payment where id = #{id}")
    Payment getPaymentById(@Param("id") Long id);
}
