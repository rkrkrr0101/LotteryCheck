package com.lottery.check.speetto.domain

import com.lottery.check.speetto.SpeettoKind
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Speetto1000Test{
    lateinit var speetto: Speetto
    @BeforeEach
    fun init(){
        speetto= Speetto1000(10,3,1,10000,30)
    }

    @Test
    fun 스피또는_자신의_당첨금_총액을_계산할수있다(){
        val totalMoney=speetto.sumTotalRewardMoney()

        Assertions.assertThat(totalMoney).isEqualTo(1904724997)

    }
    @Test
    fun 스피또는_자신의_남은복권가격의_총액을_계산할수있다(){
        val costMoney = speetto.sumTotalCostMoney()

        Assertions.assertThat(costMoney).isEqualTo(1845000000)
    }
    @Test
    fun 스피또는_자신의_가격대비효율을_계산할수있다(){
        val rewardEfficiency = speetto.calculateRewardEfficiency()

        Assertions.assertThat(rewardEfficiency).isGreaterThan(1.0).isLessThan(1.1)
    }
    @Test
    fun 스피또는_자신의_판매율을_계산할수_있다(){
        val salesRate = speetto.calculateSalesRate()

        Assertions.assertThat(salesRate).isGreaterThan(0.95).isLessThan(0.96)
    }
    @Test
    fun 스피또는_자신의_종류를_반환할수_있다(){
        val speettoKind = speetto.getKind()

        Assertions.assertThat(speettoKind).isEqualTo(SpeettoKind.Thousand)
    }
}