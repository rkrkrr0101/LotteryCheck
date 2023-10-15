package com.lottery.check.common

import java.lang.IllegalArgumentException

enum class SpeettoKind {
    TwoThousand,Thousand,FiveHundred;


    companion object {
        fun getSpeettoKind(kind: String) =
            when (kind) {
                "2000" -> TwoThousand
                "1000" -> Thousand
                "500" -> FiveHundred
                else -> {
                    throw IllegalArgumentException("IllegalSpeettoKind")
                }
            }
    }


}