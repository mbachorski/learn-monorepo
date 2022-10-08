package pl.bachorski.kotlin.generics

import org.junit.Test

class SimpleGenericsTest {
    @Test
    fun addition_isCorrect() {
        println("---")

        val bikeContainer = Container<Bike>()
        bikeContainer.load(Bike("NS"))
        println("is Loaded? : ${bikeContainer.isLoaded()}")
        val unloadedBike = bikeContainer.unload()
        println("is Loaded? : ${bikeContainer.isLoaded()}")

        println("---")

        val car = Car("Honda").also { it.drive(10) }
        val jeep = Jeep("Land Rover").also { it.drive(10) }
        val truck = Truck("Land Rover").also { it.drive(10) }

        val carTowTruck = CarTowTruck()
        carTowTruck.load(jeep)
        println("is Loaded? : ${carTowTruck.isLoaded()}")
        val unloadedJeep = carTowTruck.unload()
        println("is Loaded? : ${carTowTruck.isLoaded()}")

        println("---")

        val carContainer = Container<Car>()
        carContainer.load(car)
        println("is Loaded? : ${carContainer.isLoaded()}")
        val unloadedCar = carContainer.unload()
        println("is Loaded? : ${carContainer.isLoaded()}")

        println("---")

        val parkingLot = CarParking()
        val honda = Car("Honda")
        val teslaSemi = Truck("Tesla")
        val trucks = listOf<Truck>(Truck("Tesla"), Truck("Tesla"))
        parkingLot.park(honda)
        parkingLot.park(teslaSemi)
        parkingLot.parkMany(trucks)

        val carsFromParking = parkingLot.driveOffAll()
        println("${carsFromParking[0]}, ${carsFromParking[1]},")
        println("---")
    }

    @Test
    fun genericParking() {
        val parkingLot = GenericParking<Truck>()
        val trucks = listOf<Truck>(Truck("Tesla"), Truck("Tesla"))

        parkingLot.parkMany(trucks)
        val carsFromParking = parkingLot.driveOffAll()

        println("${carsFromParking[0]}, ${carsFromParking[1]},")

        println("---")

        val jeeps = listOf<Car>(Jeep("KIA"), Jeep("Nissan"))
//        parkingLot.parkMany(jeeps)
    }

    @Test
    fun genericParking2() {
        val parkingLot = GenericParking<Car>()

        val trucks = listOf(Truck("Tesla"))
        val jeeps = listOf(Jeep("KIA"))

        parkingLot.parkMany(trucks)
        parkingLot.parkMany(jeeps)

        val carsFromParking = parkingLot.driveOffAll()

        println("${carsFromParking[0]}, ${carsFromParking[1]},")

//        val truck: Truck = carsFromParking[0] // Required Truck, found car

        println("---")
    }
}