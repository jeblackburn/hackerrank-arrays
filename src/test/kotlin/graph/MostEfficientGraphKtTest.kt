package graph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MostEfficientGraphKtTest {
    @Test
    fun `should connect cities`() {
        //3 3 2 1     n = 3, cities[] size m = 3, c_lib = 2, c_road = 1
        //1 2         cities = [[1, 2], [3, 1], [2, 3]]
        //3 1
        //2 3
        val roads = arrayOf(arrayOf(1, 2), arrayOf(3, 1), arrayOf(2, 3))
        assertEquals(4, roadsAndLibraries(3, 2, 1, roads))
    }


    @Test
    fun `libraries cheaper than roads`() {
        //6 6 2 5
        //1 3
        //3 4
        //2 4
        //1 2
        //2 3
        //5 6
        val roads = arrayOf(
            arrayOf(1, 3),
            arrayOf(3, 4),
            arrayOf(2, 4),
            arrayOf(1, 2),
            arrayOf(2, 3),
            arrayOf(5, 6)
        )
        assertEquals(12, roadsAndLibraries(6, 2, 5, roads))

    }

    @Test
    fun name() {
        val s = "**|*|**"
        println(s.substringAfter("|"))
        val x = arrayOf(1, 2, 3)
        val y = arrayOf(4, 5, 6)
        val z = x.zip(y)
//        println(z)
//        println("lalala ${y}")
//        s.split('|')
    }
}