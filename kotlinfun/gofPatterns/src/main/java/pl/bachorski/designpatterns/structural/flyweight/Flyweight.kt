package pl.bachorski.designpatterns.structural.flyweight

interface Flyweight {
    fun operation(extrinsicState: Int): String
}

/**
 * intrinsicState invariant, shared
 * extrinsicState specific to the object
 */
class Flyweight1(private val intrinsicState: String) : Flyweight {
    override fun operation(extrinsicState: Int) = intrinsicState + extrinsicState
}

class UnsharedFlyweight : Flyweight {
    override fun operation(extrinsicState: Int) = extrinsicState.toString()
}

object FlyweightFactory {
    private val flyweights = HashMap<String, Flyweight>()

    fun getSize() = flyweights.size.also { println("getSize $it") }

    fun getFlyweight(key: String): Flyweight {
        if (flyweights.containsKey(key)) {
            println("Sharing flyweight with key $key")
            return flyweights[key]!!
        } else {
            with(Flyweight1(key)) {
                println("Creating flyweight with key $key")
                flyweights[key] = this
                return this
            }
        }
    }

    fun getUnsharedFlyweight() = UnsharedFlyweight()
}