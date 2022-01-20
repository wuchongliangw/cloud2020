package com.nacos.mapper;

import java.util.List;
import com.nacos.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminMapper {

    int insert(UmsAdmin record);

    List<UmsAdmin> selectByUsername(@Param("username") String username);
}