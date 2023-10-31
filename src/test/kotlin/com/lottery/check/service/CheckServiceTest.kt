package com.lottery.check.service

import com.lottery.check.crawlManager.CrawlManager
import com.lottery.check.crawlManager.CrawlManagerImpl
import com.lottery.check.jsoupmanager.FakeJsoupManager
import com.lottery.check.speetto.SpeettoKind
import com.lottery.check.speetto.SpeettoKind.*
import com.lottery.check.speetto.dto.SpeettoEfficiencyResponseDto
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class CheckServiceTest {
    lateinit var checkService: CheckService
    lateinit var calculateEfficiency:List<SpeettoEfficiencyResponseDto>
    val answerList=mutableListOf<SpeettoEfficiencyResponseDto>()//정답리스트
    @BeforeEach
    fun init(){
        checkService= CheckService(CrawlManagerImpl(),FakeJsoupManager())
        calculateEfficiency = checkService.calculateEfficiency()
        answerList.add(SpeettoEfficiencyResponseDto(kind= TwoThousand, episode=50, saleRate=0.02, efficiency=0.559))
        answerList.add(SpeettoEfficiencyResponseDto(kind=TwoThousand, episode=49, saleRate=0.9, efficiency=0.69))
        answerList.add(SpeettoEfficiencyResponseDto(kind=Thousand, episode=75, saleRate=0.139, efficiency=0.555))
        answerList.add(SpeettoEfficiencyResponseDto(kind=Thousand, episode=73, saleRate=0.954, efficiency=0.663))
        answerList.add(SpeettoEfficiencyResponseDto(kind=FiveHundred, episode=43, saleRate=0.845, efficiency=0.662))
        answerList.add(SpeettoEfficiencyResponseDto(kind=FiveHundred, episode=42, saleRate=0.957, efficiency=0.832))
    }

    @Test
    fun 올바른_갯수의_결과를_반환한다() {


        assertThat(calculateEfficiency.size).isEqualTo(6)

        assertThat(
            calculateEfficiency.filter {it.kind== TwoThousand }
            .toList()
            .size
        ).isEqualTo(2)
        assertThat(
            calculateEfficiency.filter {it.kind== Thousand }
                .toList()
                .size
        ).isEqualTo(2)
        assertThat(
            calculateEfficiency.filter {it.kind== FiveHundred }
                .toList()
                .size
        ).isEqualTo(2)
    }
    @Test
    fun 올바른_판매율을_반환한다(){

        assertThat(
            calculateEfficiency.filter {it.kind==TwoThousand && it.episode==50 && it.saleRate== 0.02 }
                .toList()
                .size
        ).isEqualTo(1)
        assertThat(
            calculateEfficiency.filter {it.kind==Thousand && it.episode==75 && it.saleRate== 0.139 }
                .toList()
                .size
        ).isEqualTo(1)
        assertThat(
            calculateEfficiency.filter {it.kind==FiveHundred && it.episode==43 && it.saleRate== 0.845 }
                .toList()
                .size
        ).isEqualTo(1)



    }
    @Test
    fun 올바른_효율을_반환한다(){
        assertThat(
            calculateEfficiency.filter {it.kind==TwoThousand && it.episode==50 && it.efficiency== 0.559 }
                .toList()
                .size
        ).isEqualTo(1)
        assertThat(
            calculateEfficiency.filter {it.kind==Thousand && it.episode==75 && it.efficiency== 0.555 }
                .toList()
                .size
        ).isEqualTo(1)
        assertThat(
            calculateEfficiency.filter {it.kind==FiveHundred && it.episode==43 && it.efficiency== 0.662 }
                .toList()
                .size
        ).isEqualTo(1)
    }
}