package com.lottery.check.common

import java.math.RoundingMode
import java.text.DecimalFormat



interface Speetto {
    val episode:Int
    val first:Int
    val second:Int
    val third:Int
    val quantityLeft:Int
    val speettoReward:SPEETTO_REWARD


    fun countQuantity(crawlThirdQuantity: Int, totalThirdQuantity: Int): Double {
        if (crawlThirdQuantity == totalThirdQuantity) return 0.0
        val currentThirdSoldQuantity:Double = (totalThirdQuantity.toDouble() - crawlThirdQuantity.toDouble())

        val df=DecimalFormat("#.###")
        df.roundingMode=RoundingMode.FLOOR
        return df.format(currentThirdSoldQuantity / totalThirdQuantity).toDouble()
    }
    fun getQuantityLate():Double{
        return countQuantity(third,speettoReward.WINNERCOUNTLIST[2])
    }
    fun getTotalRewardMoney():Long{
        val rewardMoneyList= speettoReward.MONEYLIST
        val rewardWinnersCountList= mutableListOf(first,second,third)
        val FIRST_TO_THIRD=3
        val etcRewardList=speettoReward.WINNERCOUNTLIST.subList(
            FIRST_TO_THIRD,
            speettoReward.WINNERCOUNTLIST.size
        )

        for (etcWinnerCount in etcRewardList) {
            rewardWinnersCountList.add(( (1-getQuantityLate()) * etcWinnerCount).toInt())
        }

        var totalReward:Long=0
        for (i in rewardMoneyList.indices) {
            totalReward+=rewardMoneyList[i].toLong()*rewardWinnersCountList[i]
        }
        return totalReward
    }



}
