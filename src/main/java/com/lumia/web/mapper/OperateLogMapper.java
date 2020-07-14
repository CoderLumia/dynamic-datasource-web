package com.lumia.web.mapper;

import com.lumia.web.entity.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OperateLogMapper {

    @Insert("insert into tb_log(type, `desc`, module, operate_time, ip) values(#{type}, #{desc}, #{module}, #{operateTime}, #{ip})")
    int save(OperateLog operateLog);
}
