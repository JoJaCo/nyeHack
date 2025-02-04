fun main(args: Array<String>) {


    val player = player()
    player.name = "estragon"
    print(player.name + "TheBrave")
    player.castFireball()

    //Aura
    player.auraColor()

    println()
    printPlayerStatus(player)


    //PlayerStatus
    println()


}

private fun printPlayerStatus(player:player){
    println("(Aura: ${player.auraColor()})" +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}








