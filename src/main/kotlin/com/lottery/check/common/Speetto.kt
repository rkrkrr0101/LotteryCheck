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

    fun calculateRewardEfficiency():Double{
        val totalRewardMoney=sumTotalRewardMoney()
        val totalCostMoney=sumTotalCostMoney()
        return roundToDecimal(totalRewardMoney.toDouble()/ totalCostMoney.toDouble())

    }

    fun sumTotalRewardMoney():Long{
        val rewardMoneyList= speettoReward.MONEYLIST
        val rewardWinnersCountList= mutableListOf(first,second,third)
        val FIRST_TO_THIRD=3
        val etcRewardList=speettoReward.WINNERCOUNTLIST.subList(
            FIRST_TO_THIRD,
            speettoReward.WINNERCOUNTLIST.size
        )

        for (etcWinnerCount in etcRewardList) {
            rewardWinnersCountList.add(( (1-calculateSalesRate()) * etcWinnerCount).toInt())
        }

        var totalReward:Long=0
        for (i in rewardMoneyList.indices) {
            totalReward+=rewardMoneyList[i].toLong()*rewardWinnersCountList[i]
        }
        println("totalReward"+totalReward)
        return totalReward
    }

    fun sumTotalCostMoney():Long{
        val cost:Long=speettoReward.COST.toLong()
        val remainingTickets:Long= (speettoReward.TOTAL_QUANTITY.toLong()*(1-calculateSalesRate())).toLong()
        println("totalCost"+cost*remainingTickets)
        return cost*remainingTickets
    }
    fun calculateSalesRate(): Double {
        val totalThirdQuantity=speettoReward.WINNERCOUNTLIST[2]
        if (third == totalThirdQuantity) return 0.0
        val currentThirdSoldQuantity:Double = (totalThirdQuantity.toDouble() - third.toDouble())

        return roundToDecimal(currentThirdSoldQuantity / totalThirdQuantity)
    }
    private fun roundToDecimal(num:Double,decimalPlaces:Int=3):Double{
        var decimalPlaceString=""
        for(i in 1..decimalPlaces){
            decimalPlaceString+="#"
        }
        val df=DecimalFormat("#.$decimalPlaceString")
        df.roundingMode=RoundingMode.FLOOR
        return df.format(num).toDouble()
    }


}

