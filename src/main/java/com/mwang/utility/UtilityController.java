package com.mwang.utility;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilityController {
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}