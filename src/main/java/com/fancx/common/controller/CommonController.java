package com.fancx.common.controller;

import com.fancx.common.result.CommonResultData;
import com.fancx.common.result.CommonResultUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common")
public class CommonController {
    @GetMapping("/checkLogin")
    public CommonResultData checkLogin() {
        //什么也不用做,只是触发拦截器来判断是否已登录
        System.out.println("#checkLogin");
        return CommonResultUtil.success();
    }
}
