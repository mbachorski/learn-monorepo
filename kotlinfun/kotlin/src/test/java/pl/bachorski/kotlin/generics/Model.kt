package pl.bachorski.kotlin.generics

open class Car(private val manufacturer: String) {
    open fun drive(distance: Int) {
        println("The Car $manufacturer is driving $distance")
    }

    override fun toString(): String = "Car: ${this::class.java} $manufacturer"
}

class Jeep(private val manufacturer: String) : Car(manufacturer) {
    override fun drive(distance: Int) {
        println("The Jeep is driving $distance")
    }

    override fun toString(): String = "Jeep: ${this::class.java} $manufacturer"
}

class Truck(private val manufacturer: String) : Car(manufacturer) {
    override fun drive(distance: Int) {
        println("The Truck is driving $distance")
    }

    override fun toString(): String = "Truck: ${this::class.java} $manufacturer"

}

class Bike(private val manufacturer: String) {
    override fun toString(): String = "Bike: ${this::class.java} $manufacturer"
}

class Container<T> {
    private var load: T? = null

    fun isLoaded() = load != null

    fun load(newLoad: T) {
        println("Container is loading: $newLoad")
        load = newLoad
    }

    fun unload(): T? {
        println("Container is unloading: $load")
        val oldLoad = load
        load = null
        return oldLoad
    }
}

class CarTowTruck {
    private var transportedCar: Car? = null

    fun isLoaded() = transportedCar != null

    fun load(car: Car) {
        this.transportedCar = car
    }

    fun unload(): Car? {
        val car = transportedCar
        transportedCar = null
        return car
    }
}

class CarParking {
    private var cars: MutableList<Car> = mutableListOf()

    fun park(car: Car) {
        cars.add(car)
    }

    fun parkMany(carsToPark: List<Car>) {
        cars.addAll(carsToPark)
    }

    fun driveOffAll(): List<Car>{
        return cars
    }
}

class GenericParking<T>{
    private var items: MutableList<T> = mutableListOf()

    fun park(item: T) {
        items.add(item)
    }

    fun parkMany(newItems: List<T>) {
        items.addAll(newItems)
    }

    fun driveOffAll(): List<T>{
        return items
    }
}