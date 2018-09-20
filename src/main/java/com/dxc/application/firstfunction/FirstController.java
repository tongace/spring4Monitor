package com.dxc.application.firstfunction;

import com.dxc.application.gimmaster.GimMasterService;
import com.dxc.application.model.GimHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    private GimMasterService gimMasterService;

    @RequestMapping(value = "/first/{requesterName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String helloAPI(@PathVariable("requesterName") String requesterName) {

        return "hello! " + requesterName;
    }

    @RequestMapping(value = "/first/getallgimmaster", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<GimHeader> getAllGimMaster() {

        return gimMasterService.selectAllGimHeader();
    }

    @RequestMapping(value = "/first/gimheader/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GimHeader getAllGimMaster(@PathVariable("type") String gimtype) {

        return gimMasterService.selectByPrimaryKey(gimtype);
    }
}
