fun main(args: Array<String>) {


    val player = player("Kar")
    player.name = "Estragon"
    print(player.name + "- TheBrave ")

    //Fireball is cast
    player.castFireball()

    //Aura
    val auraColor = player.auraColor()

    println()
    //Player status
    printPlayerStatus(player)

    //Aura
    player.auraColor()



    //PlayerStatus
    println()


}

private fun printPlayerStatus(player:player){
    println("(Aura: ${player.auraColor()})" +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}








