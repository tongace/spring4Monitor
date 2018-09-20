package com.dxc.application.combo;

import com.dxc.application.Constants;
import com.dxc.application.model.Combo;
import com.dxc.application.mybatis.mapper.ComboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComboRepository {
    @Autowired
    ComboMapper mapper;

    @Transactional(readOnly = true)
    public List<Combo> getActiveFlagCombo() {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("activeFlag",Constants.ACTIVE_FLAG.ACTIVE.toString());
        return mapper.getActiveFlagCombo(params);
    }

    @Transactional(readOnly = true)
    public List<Combo> getAssignToCombo(String countryCd, BigDecimal issuerId, String perfCatCd, String supplierCd) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("countryCd",countryCd);
        params.put("issuerId",issuerId);
        params.put("perfCatCd",perfCatCd);
        params.put("supplierCd",supplierCd);
        params.put("activeFlag",Constants.ACTIVE_FLAG.ACTIVE.toString());
        return mapper.getAssignToCombo(params);
    }
}
