open class Room(val name: String) {
    protected open val dengerLevel = 5
    fun description() = "Room: $name \n " +
            "Danger level: ${dengerLevel}"

    open fun load() = "Nothing much to see here....."
}

open class TownSquare : Room("Town Square"){
    override val dengerLevel = super.dengerLevel - 3
    private var bellSound = "GWONG"
    final override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}

// this whole chapter is about Inheritance and how they work