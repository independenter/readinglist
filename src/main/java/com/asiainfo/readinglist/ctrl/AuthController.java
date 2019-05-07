package com.asiainfo.readinglist.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    //@RequestMapping("/")
    public String showIndex(){
        return "readingList";
    }
}
