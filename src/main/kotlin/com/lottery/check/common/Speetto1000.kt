package com.lottery.check.common

class Speetto1000(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    private val constSpeetto:SPEETTO_THOUSAND=SPEETTO_THOUSAND()
    override fun getQuantityLate(): Int {
        return countQuantity(third,constSpeetto.THIRD_QUANTITY)
    }

}