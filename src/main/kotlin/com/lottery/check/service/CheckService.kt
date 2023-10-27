package com.lottery.check.service

import com.lottery.check.common.CrawlManager
import com.lottery.check.speetto.dto.SpeettoEfficiencyResponseDto
import com.lottery.check.speetto.speetto_const.SPEETTO_CRAWLING
import org.jsoup.select.Elements
import org.springframework.stereotype.Service


@Service
class CheckService(val crawlManager: CrawlManager) {

    fun calculateEfficiency(): List<SpeettoEfficiencyResponseDto> {
        val selects: Elements = crawlManager.getJsoupElements(
            SPEETTO_CRAWLING.URL,
            SPEETTO_CRAWLING.QUERY
        )

        val speettoList = crawlManager.elementToSpeettoList(selects)

        return SpeettoEfficiencyResponseDto.speettoListToResponseDtoList(speettoList)


    }






}