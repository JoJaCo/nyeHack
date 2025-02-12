data class Coordinate(val x: Int, val y: Int){
    val isInbounds = x >= 0 && y>=0
}