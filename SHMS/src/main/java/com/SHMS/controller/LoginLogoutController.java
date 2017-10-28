package com.SHMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  
@RequestMapping("user")  
public class LoginLogoutController {  
   
    /** 
     *  login
     */  
    @RequestMapping(value = "/login", method = RequestMethod.GET)  
    public String getLoginPage(  
            @RequestParam(value = "error", required = false) boolean error,  
            ModelMap model) {  
   
        if (error == true) {  
            // Assign an error message  
            model.put("error",  
                    "You have entered an invalid username or password!");  
        } else {  
            model.put("error", "");  
        }  
        return "loginpage";  
   
    }  
   
    /** 
     * denied
     * @return
     */  
    @RequestMapping(value = "/denied", method = RequestMethod.GET)  
    public String getDeniedPage() {  
        return "deniedpage";
    }  
}
