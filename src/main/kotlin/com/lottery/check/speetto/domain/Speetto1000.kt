package com.lottery.check.speetto.domain

import com.lottery.check.speetto.SpeettoKind
import com.lottery.check.speetto.speetto_const.SPEETTO_REWARD
import com.lottery.check.speetto.speetto_const.SPEETTO_THOUSAND

class Speetto1000(
    override val episode: Int,
    override val first: Int,
    override val second: Int,
    override val third: Int,
    override val quantityLeft: Int
) : Speetto {
    override val speettoReward: SPEETTO_REWARD = SPEETTO_THOUSAND()
    override fun getKind(): SpeettoKind {
        return SpeettoKind.Thousand
    }
}