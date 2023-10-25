package com.lottery.check.speetto

import com.lottery.check.speetto.speetto_const.SPEETTO_FIVEHUNDRED
import com.lottery.check.speetto.speetto_const.SPEETTO_REWARD

class Speetto500(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    override val speettoReward: SPEETTO_REWARD = SPEETTO_FIVEHUNDRED()


    override fun getKind(): SpeettoKind {
        return SpeettoKind.FiveHundred
    }
}