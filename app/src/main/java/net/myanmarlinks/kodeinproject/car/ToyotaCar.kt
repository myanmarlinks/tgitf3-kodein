package net.myanmarlinks.kodeinproject.car

class ToyotaCar(override val color: String) : Car {
    override fun makeCar(): String {
        return "${CarType.Toyota} Car with Color $color"
    }
}