fun main(args: Array<String>) {

    Game.play()

}

object Game{
    private val player = player("Madrigal")
    private var currentRoom: Room =  TownSquare()


    init{
        println("Welcome, adventurer.")
        player.castFireball()

    }

    fun play(){
        while (true){
            //play NyetHack

            println(currentRoom.description())
            println(currentRoom.load())

            //Player status
            printPlayerStatus(player)

            print("> Enter your command:  ")
            println("Last command: ${readLine()}")
        }
    }
    //our nested GameInput class
    private class GameInput(arg: String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, {""})

    }

    private fun printPlayerStatus(player:player){
        println("(Aura: ${player.auraColor()})" +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}






