package com.lottery.check.common



interface Speetto {
    val episode:Int
    val first:Int
    val second:Int
    val third:Int
    val quantityLeft:Int
    //실수로(double) 변경?
    fun countQuantity(crawlThirdQuantity:Int,totalThirdQuantity:Int):Int{

        if (crawlThirdQuantity==totalThirdQuantity)return 0
        val currentThirdSoldQuantity= (totalThirdQuantity-crawlThirdQuantity)*100  //Int로 처리위해 100곱함

        val currentThirdQuantityLate=(currentThirdSoldQuantity/totalThirdQuantity)
        return currentThirdQuantityLate
    }
    abstract fun getQuantityLate():Int




}
