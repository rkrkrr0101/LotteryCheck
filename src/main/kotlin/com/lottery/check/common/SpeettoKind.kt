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
//        fun getConstClass(speettoKind: SpeettoKind)=
//            when (speettoKind){
//                TwoThousand->SPEETTO_TWOTHOUSAND()
//                Thousand -> SPEETTO_THOUSAND()
//                FiveHundred -> SPEETTO_FIVEHUNDRED()
//            }
    }


}