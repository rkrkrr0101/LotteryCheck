package com.lottery.check.speetto.dto

import com.lottery.check.speetto.SpeettoKind
import com.lottery.check.speetto.domain.Speetto

data class SpeettoEfficiencyResponseDto(val kind: SpeettoKind,
                                        val episode:Int,
                                        val saleRate:Double,
                                        val efficiency:Double){
    companion object{
        fun speettoListToResponseDtoList(
            speettoList: ArrayList<Speetto>
        ): ArrayList<SpeettoEfficiencyResponseDto> {
            val resDtoList = ArrayList<SpeettoEfficiencyResponseDto>()
            for (speetto in speettoList) {
                resDtoList.add(
                    speettoToResponseDto(speetto)
                )
            }
            return resDtoList
        }
        fun speettoToResponseDto(speetto:Speetto
        ): SpeettoEfficiencyResponseDto {
            return SpeettoEfficiencyResponseDto(
                speetto.getKind(),
                speetto.episode,
                speetto.calculateSalesRate(),
                speetto.calculateRewardEfficiency()
            )
        }
    }


}

