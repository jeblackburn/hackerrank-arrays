import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayMatchKtTest {

    @Test
    fun `matchingStrings returns a list of the proper length`() {
        val ints = matchingStrings(arrayOf("a", "b", "a"), arrayOf("z", "x"))
        assertEquals(2, ints.size)
    }

    @Test
    fun `returns a count for each string in queries`() {
        val strings = arrayOf("a", "c", "c")
        val queries = arrayOf("a", "c")
        assertArrayEquals(arrayOf(1, 2), matchingStrings(strings, queries))
    }
}