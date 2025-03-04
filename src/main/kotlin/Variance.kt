class Barrel<in T>( item: T)
fun main(args: Array<String>){
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic looking Fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

     fedoraBarrel = lootBarrel


}