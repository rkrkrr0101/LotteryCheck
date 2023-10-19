package com.lottery.check.common

class Speetto2000(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    private val constSpeetto:SPEETTO_TWOTHOUSAND=SPEETTO_TWOTHOUSAND()
    override fun getQuantityLate(): Int {
        return countQuantity(third,constSpeetto.THIRD_QUANTITY)
    }

}