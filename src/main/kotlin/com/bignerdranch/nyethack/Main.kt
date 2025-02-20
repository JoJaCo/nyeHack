package com.bignerdranch.nyethack

import Direction
import Room
import TownSquare

fun main(args: Array<String>) {

    Game.play()

}

object Game{
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )


    init{
        println("Welcome, adventurer.")
        player.castFireball()

    }

    fun play(){
        var playGame: Boolean = true

        while (playGame){
            //play NyetHack

            println(currentRoom.description())
            println(currentRoom.load())

            //Player status
            printPlayerStatus(player)

            print("> Enter your command:  ")
            if (readLine() == "quite"){
                playGame = false
            }else {
                println(GameInput(readLine()).processCommand())

            }
        }
    }
    //our nested GameInput class
    private class GameInput(arg: String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, {""})

        fun processCommand() = when (command.toLowerCase()){
            "move" -> move(argument)
            "quit","exit" -> false
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"


    }

    private fun move(directionInput: String) = run {
        try{
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)

            if (!newPosition.isInbounds){
                throw IllegalStateException(" $direction is out of bounds ")
            }
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "Ok, you move $direction to the ${newRoom.name} \n${newRoom.load()}"

        }catch(e: Exception){
            "Invalid direction: $directionInput."
        }
    }
    //defining the fight function
    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0){
            Thread.sleep(1000)
        }
        "Combat complete"

    }?: "There's nothing here to fight."


    private fun printPlayerStatus(player: Player){
        println("(Aura: ${player.auraColor()})" +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}






