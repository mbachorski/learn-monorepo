package pl.bachorski.kotlin.lists

import org.hamcrest.CoreMatchers.`is`
import org.junit.Test

import org.junit.Assert.*

class SimpleListsTest {

    private val numbersAsString = listOf("one", "two", "three", "four", "five")

    @Test
    fun reduce() {
        val sumOfLetters: Int = numbersAsString
            .map { it.length }
            .reduce { acc, currentLength -> acc + currentLength }
        assertThat(sumOfLetters, `is`(19))
    }

    @Test
    fun fold() {
        val sumOfLetters: Int = numbersAsString
            .map { it.length }
            .fold(0) { acc, currentLength -> acc + currentLength }
        assertThat(sumOfLetters, `is`(19))
    }
}