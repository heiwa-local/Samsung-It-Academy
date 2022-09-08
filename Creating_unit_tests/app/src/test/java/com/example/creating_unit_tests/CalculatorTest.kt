package com.example.creating_unit_tests

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private var calculator: Calculator? = null
    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun addition() {
        Assert.assertEquals(21, calculator!!.add(10, 11).toLong())
        Assert.assertEquals(11, calculator!!.add(8, 3).toLong())
        Assert.assertEquals(16, calculator!!.add(8, 8).toLong())
        Assert.assertEquals(-2, calculator!!.add(-1, -1).toLong())
        Assert.assertEquals(-5, calculator!!.add(-5, 0).toLong())
        Assert.assertEquals(0, calculator!!.add(-5, 5).toLong())
    }

    @Test
    fun subtraction() {
        Assert.assertEquals(-1, calculator!!.subtract(10, 11).toLong())
        Assert.assertEquals(0, calculator!!.subtract(8, 8).toLong())
        Assert.assertEquals(7, calculator!!.subtract(15, 8).toLong())
        Assert.assertEquals(5, calculator!!.subtract(5, 0).toLong())
        Assert.assertEquals(-1, calculator!!.subtract(-5, -4).toLong())
        Assert.assertEquals(-9, calculator!!.subtract(-5, 4).toLong())
    }

    @Test
    fun multiplication() {
        Assert.assertEquals(110, calculator!!.multiply(10, 11).toLong())
        Assert.assertEquals(0, calculator!!.multiply(8, 0).toLong())
        Assert.assertEquals(0, calculator!!.multiply(0, 8).toLong())
        Assert.assertEquals(-5, calculator!!.multiply(5, -1).toLong())
        Assert.assertEquals(20, calculator!!.multiply(-5, -4).toLong())
        Assert.assertEquals(0, calculator!!.multiply(-5, 0).toLong())
        Assert.assertEquals(100000000, calculator!!.multiply(10000, 10000).toLong())
    }

    @Test
    fun division() {
        Assert.assertEquals(1, calculator!!.divide(11, 11).toLong())
        Assert.assertEquals(6, calculator!!.divide(30, 5).toLong())
        Assert.assertEquals(0, calculator!!.divide(0, 8).toLong())
        Assert.assertEquals(-5, calculator!!.divide(5, -1).toLong())
        Assert.assertEquals(1, calculator!!.divide(-5, -5).toLong())
        Assert.assertEquals(0, calculator!!.divide(-5, 0).toLong())
        Assert.assertEquals(1, calculator!!.divide(10000, 10000).toLong())
    }

    @Test
    fun allOperations() {
        Assert.assertEquals(0, calculator!!.subtract(calculator!!.add(calculator!!.divide(30, 5),
            calculator!!.multiply(6, 5)), calculator!!.add(calculator!!.divide(30, 5),
            calculator!!.multiply(6, 5))))

        Assert.assertEquals(0, calculator!!.divide(calculator!!.add(calculator!!.divide(30, 0),
            calculator!!.divide(6, 5)), calculator!!.multiply(calculator!!.multiply(30, 5),
            calculator!!.add(6, 5))))

        Assert.assertEquals(60, calculator!!.subtract(calculator!!.add(calculator!!.subtract(30, 35),
            calculator!!.multiply(6, 5)), calculator!!.add(calculator!!.divide(30, 6),
            calculator!!.add(-40, 0))))

        Assert.assertEquals(-60, calculator!!.add(calculator!!.subtract(calculator!!.divide(30, 6),
            calculator!!.multiply(6, 5)), calculator!!.add(calculator!!.divide(30, 6),
            calculator!!.add(-40, 0))))
    }

    @After
    fun tearDown() {
        calculator = null
    }
}