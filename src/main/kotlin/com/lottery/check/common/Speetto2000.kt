package com.lottery.check.common

class Speetto2000(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    override val speettoReward:SPEETTO_REWARD=SPEETTO_TWOTHOUSAND()

}