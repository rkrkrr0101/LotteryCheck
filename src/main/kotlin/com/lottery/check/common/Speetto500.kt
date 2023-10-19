package com.lottery.check.common

class Speetto500(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    private val constSpeetto:SPEETTO_FIVEHUNDRED=SPEETTO_FIVEHUNDRED()
    override fun getQuantityLate(): Int {
        return countQuantity(third,constSpeetto.THIRD_QUANTITY)
    }
}