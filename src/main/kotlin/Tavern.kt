const val TAVERN_NAME = "Taernl's Folly"

fun main(args: Array<String>){
    placeOrder("Shandy,Dragon’s Breath,5.91")


}



private fun placeOrder(menueData: String){

    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("Madrigal speaks with $tavernMaster about their order")

    val (type, name, price) = menueData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."

    println(message)

    val phrase = "Ah, delicious $name!"
    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")

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

