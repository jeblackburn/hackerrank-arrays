package stack

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StackKtTest {

    @Test
    fun `getMax adds values to the stack`() {
        val commands = arrayOf("1 97", "3")
        assertArrayEquals(arrayOf(97), getMax(commands))
    }

    @Test
    fun `getMax removes values from max list`() {
        val commands = arrayOf("1 97", "1, 100", "2", "3")
        assertArrayEquals(arrayOf(97), getMax(commands))
    }

    @Test
    fun `should ignore removal of lesser values`() {
        val commands = arrayOf("1 97", "2", "1 20", "2", "1 26", "1 20", "2", "3", "1 91", "3")
        assertArrayEquals(arrayOf(26, 91), getMax(commands))
    }
}