package com.lottery.check.service

import com.lottery.check.common.*
import com.lottery.check.common.SpeettoKind.*
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import kotlin.reflect.typeOf


@Service
class CheckService {
    fun test(){
        val selects: Elements = getJsoupElements(
            SPEETTO_CRAWLING.URL,
            SPEETTO_CRAWLING.QUERY)
        val speettoList=ArrayList<Speetto>()
        for (select in selects) {
            speettoList.add(htmlToSpeetto(select))
        }

        println(speettoList)



    }

    private fun htmlToSpeetto(select: Element):Speetto {
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
            TwoThousand -> Speetto2000(episode,first,second,third,quantity)
            Thousand -> Speetto1000(episode, first, second, third, quantity)
            FiveHundred -> Speetto500(episode,first,second,third,quantity)
        }

    }

    fun getJsoupElements( url: String, query: String): Elements {
        val conn = createJSoupConnection(url)
        return conn.get().select(query)

    }


    fun createJSoupConnection(url:String):Connection{
        return Jsoup.connect(url)
    }


}