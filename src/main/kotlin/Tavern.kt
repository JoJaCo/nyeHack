const val TAVERN_NAME = "Taernl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>){
    placeOrder("Shandy,Dragon’s Breath,5.91")

}

fun performPurchase(){
    displayBalance()
}

fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , silver: $playerSilver")
}


private fun placeOrder(menueData: String){

    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("Madrigal speaks with $tavernMaster about their order")

    val (type, name, price) = menueData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    performPurchase()

    val phrase = if (name == "Dragon's Breath"){
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    }else{
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)

    }

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")){
        when (it.value){
            "a" -> "4"
            "e" -> "4"
            "i" -> "4"
            "o" -> "4"
            "u" -> "4"
            else -> it.value
        }
    }

