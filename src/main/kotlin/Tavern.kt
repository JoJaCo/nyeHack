fun main(args: Array<String>){
    var beverage = readLine()?.let {
        if (it.isNotBlank()){
            it.capitalize()
        }else{
            "Butered Ale"
        }
    }
    //beverage = null

    println(beverage)
}