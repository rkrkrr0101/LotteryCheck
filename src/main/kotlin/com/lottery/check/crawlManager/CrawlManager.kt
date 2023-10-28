package com.lottery.check.crawlManager

import com.lottery.check.speetto.domain.Speetto
import org.jsoup.Connection
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

interface CrawlManager {
    fun elementToSpeettoList(selects: Elements): ArrayList<Speetto>
    fun htmlToSpeetto(select: Element): Speetto

}