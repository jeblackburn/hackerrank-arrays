package hashmap

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class KidnapperKtTest {

    @Test
    fun `checkMagazine matches one word`() {
        assertTrue(checkMagazine(arrayOf("hello"), arrayOf("hello")))
    }

    @Test
    fun `more instances of word in note than in magazine`() {
        assertFalse(checkMagazine(arrayOf("hello", "goodbye"), arrayOf("hello", "hello", "goodbye")))
    }

    @Test
    fun `rejects if one word missing`() {
        assertFalse(checkMagazine(arrayOf("hello", "goodbye"), arrayOf("heythere", "hello", "goodbye")))
    }

    @Test
    fun `rejects on case mismatch`() {
        assertFalse(checkMagazine(arrayOf("Hello", "goodbye"), arrayOf("hello", "hello", "goodbye")))
    }
}