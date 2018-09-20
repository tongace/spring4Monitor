package com.dxc.application.combo;

import com.dxc.application.model.Combo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ComboController {

    @Autowired
    private ComboRepository comboRepository;

    @RequestMapping(value = "/combo/activeflag",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Combo> getActiveFlagCombo() {

        return comboRepository.getActiveFlagCombo();
    }

    @RequestMapping(
                value = "/combo/assignto/{countryCd}/{issuerId}/{perfCatCd}/{supplierCd}",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Combo> getAssignToCombo(@PathVariable("countryCd") String countryCd,
                                        @PathVariable("issuerId") BigDecimal issuerId,
                                        @PathVariable("perfCatCd") String perfCatCd,
                                        @PathVariable("supplierCd") String supplierCd) {

        return comboRepository.getAssignToCombo(countryCd,issuerId,perfCatCd,supplierCd);
    }
}
