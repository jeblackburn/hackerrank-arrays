package sorting

import countSort
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberSortKtTest {
    @Test
    fun `should sort by number`() {
        val inputs = arrayOf(arrayOf("0", "ab"), arrayOf("6", "cd"))
        val result = countSort(inputs)
        assertEquals("- cd", result)

    }

    @Test
    fun `should pass example`() {
        val inputs = arrayOf(
            arrayOf("0", "ab"),
            arrayOf("6", "cd"),
            arrayOf("0", "ef"),
            arrayOf("6", "gh"),
            arrayOf("4", "ij"),
            arrayOf("0", "ab"),
            arrayOf("6", "cd"),
            arrayOf("0", "ef"),
            arrayOf("6", "gh"),
            arrayOf("0", "ij"),
            arrayOf("4", "that"),
            arrayOf("3", "be"),
            arrayOf("0", "to"),
            arrayOf("1", "be"),
            arrayOf("5", "question"),
            arrayOf("1", "or"),
            arrayOf("2", "not"),
            arrayOf("4", "is"),
            arrayOf("2", "to"),
            arrayOf("4", "the"),
        )
        val result = countSort(inputs)
        assertEquals("- - - - - to be or not to be - that is the question - - - -",
            result)

    }
}


//20
