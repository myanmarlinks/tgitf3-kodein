package net.myanmarlinks.kodeinproject.car

class CarFactory() {
    fun create(carColor: CarColor, carType: CarType): Car {
        val color = when(carColor) {
            CarColor.RED -> "RED"
            CarColor.BLUE -> "BLUE"
            CarColor.GREEN -> "GREEN"
        }
        return when(carType) {
            CarType.Mazada -> MazadaCar(color)
            CarType.Nissan -> NissanCar(color)
            CarType.Toyota -> ToyotaCar(color)
        }
    }
}