package com.motorway.android.wordcount

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class WordCounterViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `Given there are characters without space it returns count as one`() {
        val sut = WordCounterViewModel()

        sut.updateCount("1232eddd")

        assertEquals(1, sut.count.value)
    }

    @Test
    fun `Given there are characters with space it returns count for words`() {
        val sut = WordCounterViewModel()

        sut.updateCount("1232eddd motorway")

        assertEquals(2, sut.count.value)
    }

    @Test
    fun `Given there are characters with enter value it returns count for words as one`() {
        val sut = WordCounterViewModel()

        sut.updateCount("1232eddd\nmotorway")

        assertEquals(1, sut.count.value)
    }

    @Test
    fun `Given there are characters with space at the end it returns count for words as one`() {
        val sut = WordCounterViewModel()

        sut.updateCount("1232edddmotorway ")

        assertEquals(1, sut.count.value)
    }

    @Test
    fun `Given there are characters with space at the beginning it returns count for words as one`() {
        val sut = WordCounterViewModel()

        sut.updateCount(" 1232edddmotorway ")

        assertEquals(1, sut.count.value)
    }
}