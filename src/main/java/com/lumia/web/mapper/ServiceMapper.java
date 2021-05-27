package com.lumia.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ServiceMapper {

    @Select("select service_name from service limit 1")
    String getService();
}
