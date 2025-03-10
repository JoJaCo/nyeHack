package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Taernl's Folly"

val patronList = mutableListOf("Eli","Mordoc","Sophie")
val lastName = listOf("Ironfoot","Fernsworth","Beggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt").readText().split("\n")
val patronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>){

    (0..9).forEach{
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = " $first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach{
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <=9){
        placeOrder(
            uniquePatrons.shuffled().first(),
            menuList.shuffled().first())
        orderCount++

    }

}





//placing our order for our people
private fun placeOrder(patronName: String, menueData: String){

    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    //println("Madrigal speaks with $tavernMaster about their order")
    println("$patronName speaks with $tavernMaster about their order")


    val (type, name, price) = menueData.split(',')
    //val message = "Madrigal buys a $name ($type) for $price."
    val message = "$patronName buys a $name ($type) for $price."
    println(message)



    performPurchease(price.toDouble(),patronName)

    val phrase = if (name == "Dragon's Breath"){
        //"Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
        "$patronName exclaims: ${toDragonSpeak("Ah delicious $name!")}"

    }else{
        //"Madrigal says: Thanks for the $name."
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
    println()





}
// updating the wallet to players
fun performPurchease(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}


private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")){
        when (it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

