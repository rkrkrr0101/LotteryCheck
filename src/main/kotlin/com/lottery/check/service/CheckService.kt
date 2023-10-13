package com.lottery.check.service

import com.lottery.check.domain.Speetto
import com.lottery.check.domain.SpeettoKind
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils


@Service
class CheckService {
    fun test(){
        val viewerUrl = "https://dhlottery.co.kr/common.do?method=main"
        val query = "#article > div.wrap_box.wrap1 > section.box.speetto-new.win > div.content > div > div > div > div"

        val selects: Elements = getJsoupElements(null, viewerUrl, query)
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
        return Speetto(SpeettoKind.getSpeettoKind(kind),episode,first,second,third,quantity)
    }

    fun getJsoupElements(connection: Connection?, url: String, query: String): Elements {
        val conn = if (!ObjectUtils.isEmpty(connection)) connection else createJSoupConnection(url)
        //var result: Elements? = null
        if (conn != null) {
            return conn.get().select(query)
        }
        return Elements()
        //return result
    }


    fun createJSoupConnection(url:String):Connection{
        return Jsoup.connect(url)
    }


}