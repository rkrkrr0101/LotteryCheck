package com.lottery.check.controller

import com.lottery.check.service.CheckService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/check")
class CheckController(val checkService: CheckService ) {
    @GetMapping("/a")
    fun test():String{
        checkService.test()
        return "abc"
    }

}