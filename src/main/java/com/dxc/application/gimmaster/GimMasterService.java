package com.dxc.application.gimmaster;

import com.dxc.application.model.GimHeader;
import com.dxc.application.mybatis.mapper.GimHeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GimMasterService {
    @Autowired
    GimHeaderMapper mapper;

    @Transactional(readOnly = true)
    public List<GimHeader> selectAllGimHeader() {
        return mapper.selectAllGimHeader();
    }
    @Transactional(readOnly = true)
    public GimHeader selectByPrimaryKey(String gimType) {
        GimHeader gimHeader = new GimHeader();
        gimHeader.setGimType(gimType);
        return mapper.selectGimHeaderByGimType(gimHeader);
    }
}
