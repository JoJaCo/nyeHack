const val TAVERN_NAME = "Taernl's Folly"

fun main(args: Array<String>){
    placeOrder("Shandy,Dragon’s Breath,5.91")


}



private fun placeOrder(menueData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")

        val data = menueData.split(',')
        val type = data[0]
        val name = data[1]
        val price = data[2]
        val message = "Madrigal buys a $name ($type) for $price."
        println(message)

    }


