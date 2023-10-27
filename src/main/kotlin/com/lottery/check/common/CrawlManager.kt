package com.lottery.check.common

import com.lottery.check.speetto.SpeettoKind
import com.lottery.check.speetto.domain.Speetto
import com.lottery.check.speetto.domain.Speetto1000
import com.lottery.check.speetto.domain.Speetto2000
import com.lottery.check.speetto.domain.Speetto500
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Component

@Component
class CrawlManager {
    fun elementToSpeettoList(selects: Elements): ArrayList<Speetto> {
        val speettoList = ArrayList<Speetto>()
        for (select in selects) {
            speettoList.add(htmlToSpeetto(select))
        }
        return speettoList
    }
    fun htmlToSpeetto(select: Element): Speetto {
        val kind = select.getElementsByClass("tit")[0]
            .text().split(" ")[1]
        val episode = select.getElementsByClass("tit")[0]
            .getElementsByTag("span").text().replace(",", "").toInt()
        val first = select.getElementsByClass("li1")[0]
            .getElementsByClass("num").text().replace(",", "").toInt()
        val second = select.getElementsByClass("li2")[0]
            .getElementsByClass("num").text().replace(",", "").toInt()
        val third = select.getElementsByClass("li3")[0]
            .getElementsByClass("num").text().replace(",", "").toInt()
        val quantity = select.getElementsByClass("li4")[0]
            .getElementsByClass("num").text().replace(",", "").toInt()
        return when(SpeettoKind.getSpeettoKind(kind)){
            SpeettoKind.TwoThousand -> Speetto2000(episode,first,second,third,quantity)
            SpeettoKind.Thousand -> Speetto1000(episode, first, second, third, quantity)
            SpeettoKind.FiveHundred -> Speetto500(episode,first,second,third,quantity)
        }

    }

    fun getJsoupElements( url: String, query: String): Elements {
        val conn = createJSoupConnection(url)
        return conn.get().select(query)

    }


    fun createJSoupConnection(url:String): Connection {
        return Jsoup.connect(url)
    }




}