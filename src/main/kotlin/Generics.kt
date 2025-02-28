class LootBox<T: Loot>(vararg item: T){
    var open = false
    private var loot: Array<out T> = item

    operator fun get(index: Int): T? = loot[index].takeIf{open}

    fun fetch(item: Int): T?{
        println("fetch num 1")
        return loot[item].takeIf { open }
    }

    fun <R> fetch(item: Int,lootModFunction: (T) -> R): R?{
        println("fetch number 2")
        return lootModFunction(loot[item]).takeIf{open}
    }

}

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)
class Coin(value: Int): Loot(value)

fun main(args: Array<String>){
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("A generic - looking fedora", 20),
        Fedora("a dazzling magenta fedora", 65))

    val lootBoxTwo: LootBox <Coin> = LootBox(Coin(15))


    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run{
        println("you retrieve $name form the box!")
    }

    val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }


    coin?.let { println(it.value) }

    val fedora = lootBoxOne[1] //using the get method
    fedora?.let { println(it.name) }


}