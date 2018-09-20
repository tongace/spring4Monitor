package com.dxc.application.mybatis.mapper;

import com.dxc.application.model.Combo;
import com.dxc.application.model.GimHeader;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ComboMapper {
    List<Combo> getActiveFlagCombo(Map<String,Object> params);
    List<Combo> getAssignToCombo(Map<String,Object> params);
}
