package com.lottery.check.common

class Speetto500(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    val constSpeetto:SPEETTO_FIVEHUNDRED=SPEETTO_FIVEHUNDRED()

}