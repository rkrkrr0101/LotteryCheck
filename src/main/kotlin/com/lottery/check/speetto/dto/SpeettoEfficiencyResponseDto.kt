package com.lottery.check.speetto.dto

import com.lottery.check.speetto.SpeettoKind

data class SpeettoEfficiencyResponseDto(val kind: SpeettoKind,
                                        val episode:Int,
                                        val saleRate:Double,
                                        val efficiency:Double)

