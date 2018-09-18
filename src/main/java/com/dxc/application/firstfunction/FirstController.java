package com.dxc.application.firstfunction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
    @GetMapping("/first/{requesterName}")
    @ResponseBody
    public String helloAPI(@PathVariable("requesterName") String requesterName){
        return "hello! "+requesterName;
    }
}
