package util.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.config.UserConfig;

@Controller
public class TestController {
    @Autowired
    private UserConfig userConfig;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return userConfig.getUser().toString();
    }
}
