package pl.bachorski.designpatterns.behavioral.strategy

import android.util.Log

// enables selecting an algorithm at runtime. Similar to dependency injection in structure.
interface Strategy {
    fun algorithm()
}

class Strategy1 : Strategy {
    override fun algorithm() {
        Log.v("STRATEGY", "STRATEGY 1")
    }
}

class Strategy2 : Strategy {
    override fun algorithm() = println("STRATEGY2")
}

class Context(var strategy: Strategy) {
    fun algorithm() = strategy.algorithm()
}