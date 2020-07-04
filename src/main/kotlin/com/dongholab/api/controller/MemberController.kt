package com.dongholab.api.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/member")
class MemberController {

    @RequestMapping("/success")
    fun success(request: HttpServletRequest): String {
        return "success"
    }

    @PostMapping("/postRequest")
    fun register(request: HttpServletRequest): String {
        return "test";
    }
}