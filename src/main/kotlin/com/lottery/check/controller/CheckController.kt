package com.lottery.check.controller

import com.lottery.check.common.Result
import com.lottery.check.speetto.dto.SpeettoEfficiencyResponseDto
import com.lottery.check.service.CheckService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/check")
class CheckController(val checkService: CheckService ) {
    @GetMapping("/efficiency")
    fun findEfficiency(): Result<List<SpeettoEfficiencyResponseDto>> {
        return  Result (checkService.calculateEfficiency())
    }

}