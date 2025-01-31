class player {
    var name = "Madrigal"
        get() = field.capitalize()
        set(value){
            field = value.trim()
        }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence (x$numFireballs)")



}