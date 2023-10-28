package com.lottery.check.service

import com.lottery.check.JsoupManager.JsoupManager
import com.lottery.check.crawlManager.CrawlManager
import com.lottery.check.crawlManager.CrawlManagerImpl
import com.lottery.check.speetto.dto.SpeettoEfficiencyResponseDto
import com.lottery.check.speetto.speetto_const.SPEETTO_CRAWLING
import org.jsoup.select.Elements
import org.springframework.stereotype.Service


@Service
class CheckService(val crawlManager: CrawlManager,val jsoupManager: JsoupManager) {
    fun calculateEfficiency(): List<SpeettoEfficiencyResponseDto> {
        val selects: Elements = jsoupManager.getJsoupElements(
            SPEETTO_CRAWLING.URL,
            SPEETTO_CRAWLING.QUERY
        )

        val speettoList = crawlManager.elementToSpeettoList(selects)

        return SpeettoEfficiencyResponseDto.speettoListToResponseDtoList(speettoList)
    }
}