package com.dxc.application.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public abstract class BaseModel {
    private BigDecimal createdBy;
    private Date createdDt;
    private BigDecimal modifiedBy;
    private Date modifiedDt;
}
