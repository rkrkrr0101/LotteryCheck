package com.lottery.check.speetto.domain

import com.lottery.check.speetto.domain.Speetto
import com.lottery.check.speetto.domain.Speetto500
import com.lottery.check.speetto.SpeettoKind
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Speetto500Test{
    lateinit var speetto: Speetto
    @BeforeEach
    fun init(){
        speetto= Speetto500(10,3,1,10000,30)
    }

    @Test
    fun 스피또는_자신의_당첨금_총액을_계산할수있다(){
        val totalMoney=speetto.sumTotalRewardMoney()

        assertThat(totalMoney).isEqualTo(621000000)

    }
    @Test
    fun 스피또는_자신의_남은복권가격의_총액을_계산할수있다(){
        val costMoney = speetto.sumTotalCostMoney()

        assertThat(costMoney).isEqualTo(340000000)
    }
    @Test
    fun 스피또는_자신의_가격대비효율을_계산할수있다(){
        val rewardEfficiency = speetto.calculateRewardEfficiency()

        assertThat(rewardEfficiency).isGreaterThan(1.7).isLessThan(1.9)
    }
    @Test
    fun 스피또는_자신의_판매율을_계산할수_있다(){
        val salesRate = speetto.calculateSalesRate()

        assertThat(salesRate).isGreaterThan(0.95).isLessThan(0.98)
    }
    @Test
    fun 스피또는_자신의_종류를_반환할수_있다(){
        val speettoKind = speetto.getKind()

        assertThat(speettoKind).isEqualTo(SpeettoKind.FiveHundred)
    }
}

