import java.util.SortedMap
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'countSort' function below.
 *
 * The function accepts 2D_STRING_ARRAY arr as parameter.
 */

fun countSort(arr: Array<Array<String>>): String {
    val valuesByEntry = HashMap<Int, MutableList<String>>()
    val halfway: Int = arr.size / 2
    arr.forEachIndexed { idx, s ->
        val key = s[0].toInt()
        val value = if (idx < halfway) "-" else s[1]
        valuesByEntry.getOrPut(key) { ArrayList() }.add(value)
    }
    val builder = StringBuilder()
    valuesByEntry.toSortedMap().entries.forEach { entry -> builder.append(entry.value.joinToString(prefix = " ",separator = " ")) }
    val result = builder.toString().trim()
    println(result)
    return result
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<String>>(n, { Array<String>(2, { "" }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").toTypedArray()
    }

    countSort(arr)
}
