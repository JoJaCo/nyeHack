package com.bignerdranch.nyethack

fun main (args: Array<String>){
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient){
        swordsJuggling = 2
    }
    try {


        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)

    }catch (e:Exception){
        println(e)
    }

    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?){
    swordsJuggling ?: throw  UnskilledSworJuggling()
}

class UnskilledSworJuggling:
    IllegalStateException("com.bignerdranch.nyethack.player cannot juggle swords")