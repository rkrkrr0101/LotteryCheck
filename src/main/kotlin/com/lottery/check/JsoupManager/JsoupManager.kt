package com.lottery.check.JsoupManager

import org.jsoup.Connection
import org.jsoup.select.Elements

interface JsoupManager {
    fun getJsoupElements( url: String, query: String): Elements
    fun createJSoupConnection(url:String): Connection
}