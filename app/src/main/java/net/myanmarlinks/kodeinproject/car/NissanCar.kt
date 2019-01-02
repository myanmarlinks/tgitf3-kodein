package net.myanmarlinks.kodeinproject.car

class NissanCar(override val color: String) : Car {
    override fun makeCar(): String {
        return "${CarType.Nissan} Car with Color $color"
    }
}