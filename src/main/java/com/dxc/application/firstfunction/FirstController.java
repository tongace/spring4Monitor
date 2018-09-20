package com.dxc.application.firstfunction;

import com.dxc.application.gimmaster.GimMasterService;
import com.dxc.application.model.GimHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    private GimMasterService gimMasterService;

    @GetMapping("/first/{requesterName}")
    @ResponseBody
    public String helloAPI(@PathVariable("requesterName") String requesterName){

        return "hello! "+requesterName;
    }
    @GetMapping("/first/getallgimmaster")
    @ResponseBody
    public List<GimHeader> getAllGimMaster(){

        return gimMasterService.selectAllGimHeader();
    }

    @GetMapping("/first/gimheader/{type}")
    @ResponseBody
    public GimHeader getAllGimMaster(@PathVariable("type") String gimtype){

        return gimMasterService.selectByPrimaryKey(gimtype);
    }
}
