package pl.bachorski.kotlin.coroutines

import kotlinx.coroutines.*
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class IntroToCoroutinesKtTest {
    @Test
    fun printThread() {
        val thread = Thread {
            println("${Thread.currentThread()} has run.")
        }
        thread.start()
    }

    @Test
    fun multipleThreads() {
        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
        repeat(3) {
            Thread {
                println("${Thread.currentThread()} has started")
                for (i in states) {
                    println("${Thread.currentThread()} - $i")
                    Thread.sleep(50)
                }
            }.start()
        }
        Thread.sleep(300)
    }

    class Foo

    @Test
    fun raceCondition() {
        var count = 0
        for (i in 1..50) {
            Thread {
                count += 1
                println("Thread: $i count: $count")
            }.start()
        }
    }

    @Test
    fun simpleCoroutine() {
        repeat(3) {
            GlobalScope.launch {
                println("Hi from ${Thread.currentThread()}")
            }
        }
        Thread.sleep(50)
    }

    val formatter = DateTimeFormatter.ISO_LOCAL_TIME
    val time = { formatter.format(LocalDateTime.now()) }

    suspend fun getValue(): Double {
        println("entering getValue() at ${time()}")
        delay(3000)
        println("leaving getValue() at ${time()}")
        return Math.random()
    }

    @Test
    fun blockingExample() {
        runBlocking {
            val num1 = getValue()
            val num2 = getValue()
            println("result of num1 + num2 is ${num1 + num2}")
        }
    }

    @Test
    fun blockingExampleWithAsyncInsideBlocking() {
        runBlocking {
            val num1 = async { getValue() }
            val num2 = async { getValue() }
            println("result of num1 + num2 is ${num1.await() + num2.await()}")
        }
    }

    @Test
    fun multipleThreadsOnCoroutines() {
        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
        runBlocking {
            repeat(3) {
                GlobalScope.launch {
                    println("${Thread.currentThread()} has started")
                    for (i in states) {
                        println("${Thread.currentThread()} - $i")
                        delay(50)
                    }
                }
            }
        }
        Thread.sleep(300)
    }
}