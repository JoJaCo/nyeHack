import java.io.File
import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli","Mordoc","Sophie")
val menuList = File("data/tavern-menu-items.txt").readText().split("\n")

fun main(args: Array<String>){

    if (patronList.contains("Eli")){
        println("The tavern master says: Eli's in the back playing cards")
    }else{
        println("The tavern master says: Eli isn't here.")
    }
    println()

    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line")
        placeOrder(patron,"Shandy,Dragon's Breath,5.91")
    }

    menuList.forEachIndexed{index, data ->
        println("$index: $data")
    }


}

fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver /100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    println()

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    println()
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()

}

fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , silver: $playerSilver")
}


private fun placeOrder(patronName: String, menueData: String){

    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    //println("Madrigal speaks with $tavernMaster about their order")
    println("$patronName speaks with $tavernMaster about their order")


    val (type, name, price) = menueData.split(',')
    //val message = "Madrigal buys a $name ($type) for $price."
    val message = "$patronName buys a $name ($type) for $price."
    println(message)


    //performPurchase(price.toDouble())

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

