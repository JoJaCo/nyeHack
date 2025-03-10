enum class Direction(private val coordinate: Coordinate){
    NORTH(Coordinate(0,-1)),
    EAST(Coordinate(1,0)),
    SOUTH(Coordinate(1,0)),
    WEST(Coordinate(-1,0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
        coordinate + playerCoordinate

}

data class Coordinate(val x: Int, val y: Int){
    val isInbounds = x >= 0 && y>=0

    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}