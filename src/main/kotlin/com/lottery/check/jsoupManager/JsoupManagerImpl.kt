package com.lottery.check.jsoupManager

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.stereotype.Component

@Component
class JsoupManagerImpl:JsoupManager {
    override fun getJsoupElements( url: String, query: String): Elements {
        val conn = createJSoupConnection(url)

        return conn.get().select(query)

    }


    override fun createJSoupConnection(url:String): Connection {

        return Jsoup.connect(url)
    }
}