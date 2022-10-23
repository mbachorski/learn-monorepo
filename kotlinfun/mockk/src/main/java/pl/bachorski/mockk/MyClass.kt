package pl.bachorski.mockk


interface SteeringWheel {
    fun turn(degrees: Int)
}

interface Engine {
    fun start()
    fun stop()
    fun driveForward(speed: Int, distance: Int)
    fun driveBackward(speed: Int, distance: Int)
}

class StandardSteeringWheel : SteeringWheel {
    private var turningDegrees = 0

    override fun turn(degrees: Int) {
        turningDegrees = degrees
    }
}

class StandardEngine : Engine {
    private var currentSpeed = 0

    override fun start() {}

    override fun stop() {}

    override fun driveForward(speed: Int, distance: Int) {
        currentSpeed = speed
    }

    override fun driveBackward(speed: Int, distance: Int) {
        currentSpeed = -speed
    }
}

class CarController(
    private val steeringWheel: SteeringWheel,
    private val engine: Engine
) {
    fun driveToGarage() {
        engine.start()
        engine.driveForward(15, 10)
        steeringWheel.turn(90)
        engine.driveForward(10, 10)
        steeringWheel.turn(-90)
        engine.driveForward(5, 10)
        engine.stop()
    }
}