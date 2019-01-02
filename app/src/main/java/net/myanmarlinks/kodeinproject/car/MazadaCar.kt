package net.myanmarlinks.kodeinproject.car

class MazadaCar(override val color: String) : Car {
    override fun makeCar(): String {
        return "${CarType.Mazada} Car with Color $color"
    }

}