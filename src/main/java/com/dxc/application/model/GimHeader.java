package com.dxc.application.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GimHeader extends BaseModel {
    private String gimType;
    private String gimDesc;
    private BigDecimal cdLength;
    private String field1Label;
    private String field2Label;
    private String field3Label;
    private String activeFlag;
}
