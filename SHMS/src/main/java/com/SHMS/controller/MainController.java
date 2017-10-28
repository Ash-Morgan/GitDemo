package com.SHMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
@RequestMapping("/main")  
public class MainController {  
   
    /** 
     * commonpage
     * @return
     */  
    @RequestMapping(value = "/common", method = RequestMethod.GET)  
    public String getCommonPage() {  
         return "commonpage";  
    }  
   
    /** 
     * adminpage
     * @return 
     */  
    @RequestMapping(value = "/admin", method = RequestMethod.GET)  
    public String getAadminPage() {  
        return "adminpage";  
   
    }  
   
}
