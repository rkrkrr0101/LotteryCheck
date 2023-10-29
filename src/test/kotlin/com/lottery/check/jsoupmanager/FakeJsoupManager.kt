package com.lottery.check.jsoupmanager

import com.lottery.check.JsoupManager.JsoupManager
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.File

class FakeJsoupManager:JsoupManager {
    override fun getJsoupElements(url: String, query: String): Elements {
        val file = File("src/test/kotlin/com/lottery/check/jsoupmanager/FakeHtml.html")
        val parse = Jsoup.parse(file, "UTF-8")

        return parse.select(query)
    }

    override fun createJSoupConnection(url: String): Connection {
        return Jsoup.connect(url)
    }
}