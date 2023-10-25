package com.lottery.check.speetto

import com.lottery.check.speetto.speetto_const.SPEETTO_REWARD
import com.lottery.check.speetto.speetto_const.SPEETTO_TWOTHOUSAND

class Speetto2000(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    override val speettoReward: SPEETTO_REWARD = SPEETTO_TWOTHOUSAND()
    override fun getKind(): SpeettoKind {
        return SpeettoKind.TwoThousand
    }
}