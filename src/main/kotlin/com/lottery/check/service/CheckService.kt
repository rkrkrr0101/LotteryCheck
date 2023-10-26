package com.lottery.check.service

import com.lottery.check.speetto.*
import com.lottery.check.speetto.SpeettoKind.*
import com.lottery.check.speetto.domain.Speetto
import com.lottery.check.speetto.domain.Speetto1000
import com.lottery.check.speetto.domain.Speetto2000
import com.lottery.check.speetto.domain.Speetto500
import com.lottery.check.speetto.dto.SpeettoEfficiencyResponseDto
import com.lottery.check.speetto.speetto_const.SPEETTO_CRAWLING
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Service


@Service
class CheckService(val crawlService:CrawlService) {

    fun calculateEfficiency(): List<SpeettoEfficiencyResponseDto> {
        val selects: Elements = crawlService.getJsoupElements(
            SPEETTO_CRAWLING.URL,
            SPEETTO_CRAWLING.QUERY
        )

        val speettoList = crawlService.ElementToSpeettoList(selects)

        return crawlService.speettoToResponseDto(speettoList)


    }






}