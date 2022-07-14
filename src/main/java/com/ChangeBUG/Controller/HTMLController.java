package com.ChangeBUG.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLController {

    @RequestMapping(value = "/")
    public String index() {
        return "hello";
    }

}
