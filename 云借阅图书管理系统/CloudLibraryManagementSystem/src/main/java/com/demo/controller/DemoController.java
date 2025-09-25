package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.controller
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  16:24
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class DemoController {

    /**
     * 测试配置文件是否能打开网页
     * @return
     */
    @RequestMapping("/demo")
    @ResponseBody
    public String demo() {
        return "success";
    }
}

