package com.dxc.application.mybatis.mapper;

import com.dxc.application.model.GimHeader;

import java.util.List;

public interface GimHeaderMapper {
    List<GimHeader> selectAllGimHeader();

    GimHeader selectGimHeaderByGimType(GimHeader gimHeader);
}
