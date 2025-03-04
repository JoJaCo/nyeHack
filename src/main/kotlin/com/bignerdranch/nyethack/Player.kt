package com.bignerdranch.nyethack

import Coordinate
import java.io.File

class Player(_name: String,
             override var healthPoints: Int = 100, //here
             val isBlessed: Boolean,
             private val isImmortal: Boolean): Fightable {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        set(value){
            field = value.trim()
        }


    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence (x$numFireballs)")

    //getting the name of the heros hometown
    val hometown by lazy {selectHometown()}  //Lazy initialization
    var currentPosition = Coordinate(0, 0)

    //getting data from the file
    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()



    init{
        require(healthPoints > 0) { "healthPoints must be greater than zero." }
        require(name.isNotBlank()) { "Player must have a name." }

    }


    //Secondary constructor
    constructor(name: String): this(name,
        healthPoints = 100,
        isBlessed = true,
        isImmortal = false){
        if (name.toLowerCase() == "kar"){
            healthPoints = 40 //here
        }
    }

    fun auraColor():String{
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }


    fun formatHealthStatus() =
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

    override val diceCount = 3

    override val diceSides: Int = 6


    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed){
            damageRoll * 2
        }else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt

    }


}