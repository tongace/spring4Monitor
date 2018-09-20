package com.dxc.application.mybatis.mapper;

import com.dxc.application.model.GimHeader;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface GimHeaderMapper {
    public List<GimHeader> selectAllGimHeader();
    public GimHeader selectGimHeaderByGimType(GimHeader gimHeader);
}
