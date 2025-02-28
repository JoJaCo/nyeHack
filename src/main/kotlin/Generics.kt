class LootBox<T>(item: T){
    var open = false
    private var loot: T = item

    fun fetch(): T?{
        return loot.takeIf { open }
    }

    fun <R> fetch(lootModFunction: (T) -> R): R?{
        println("fetch number 2")
        return lootModFunction(loot).takeIf{open}
    }

}

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)
class Coin(value: Int): Loot(value)

fun main(args: Array<String>){
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("A generic - looking fedora", 20))
    val lootBoxTwo: LootBox <Coin> = LootBox(Coin(15))


    lootBoxOne.open = true
    lootBoxOne.fetch()?.run{
        println("you retrieve $name form the box!")
    }

    val coin = lootBoxOne.fetch(){
        Coin(it.value * 3)
    }

    coin?.let { println(it.value) }


}