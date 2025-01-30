fun main(args: Array<String>) {
    var healthPoints = 89
    var isBlessed = true
    var isImmortal = false

    val player = player()
    player.castFireball()

    //Auro
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    println()
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    //PlayerStatus
    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)
    println()


}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints){
        100 ->"is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed){
            "has soome minor wounds, but is healing quite quickly!"
        }else{
            "has some minor wounds"
        }
        in 15..74 -> "looks pretty hurt"
        else -> "is in awful condition!"
    }



private fun printPlayerStatus(auraColor: String,
                              isBlessed: Boolean,
                              name: String,
                              healthStatus: String){
    println("(Aura: $auraColor)" +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean,
                      healthPoints: Int,
                      isImomortal: Boolean):String{

    val auraVisible = isBlessed && healthPoints > 50 || isImomortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}







