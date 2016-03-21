package com.aiton.bmzc.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2016/3/19.
 */
@Controller
public class ZcAccountController {
    @RequestMapping("/toZC_Account")
    public String execute(){
        return "zc_account";
    }
}
