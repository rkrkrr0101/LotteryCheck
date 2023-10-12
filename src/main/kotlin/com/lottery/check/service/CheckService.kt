package com.lottery.check.service

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils


@Service
class CheckService {
    fun test(){
        val viewerUrl = "https://dhlottery.co.kr/common.do?method=main"
        val query = "#article > div.wrap_box.wrap1 > section.box.speetto-new.win > div.content > div > div > div > div"

        val selects: Elements? = getJsoupElements(null, viewerUrl, query)

        println("1번"+selects?.get(0)?.text())
        println("2번"+selects?.get(0)?.html())
        println("3번"+selects?.get(0)?.children())
        println("4번"+selects?.get(0)?.parent())
        println("5번"+selects?.get(1)?.parent()!!.previousElementSibling())
    }

    fun getJsoupElements(connection: Connection?, url: String, query: String): Elements? {
        val conn = if (!ObjectUtils.isEmpty(connection)) connection else createJSoupConnection(url)
        var result: Elements? = null
        if (conn != null) {
            result = conn.get().select(query)
        }
        return result
    }


    fun createJSoupConnection(url:String):Connection{
        return Jsoup.connect(url)
    }


}