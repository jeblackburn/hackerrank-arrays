package stack

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'getMax' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY operations as parameter.
 */

fun getMax(operations: Array<String>): Array<Int> {
    val stack = Stack<Int>()
    val maxValues = Stack<Int>()
    val results = ArrayList<Int>()
    operations.forEach { action ->
        if (action.startsWith("1")) {
            val newValue = action.split(" ")[1].toInt()
            stack.push(newValue)
            if (maxValues.empty() || newValue >= maxValues.peek()) {
                maxValues.push(newValue)
            }
        } else if (action == "2") {
            val popped = stack.pop()
            if (popped == maxValues.peek()) {
                maxValues.pop()
            }
        }
        else if (action == "3") {
            results.add(maxValues.peek())
        }
    }
    return results.toTypedArray()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ops = Array<String>(n, { "" })
    for (i in 0 until n) {
        val opsItem = readLine()!!
        ops[i] = opsItem
    }

    val res = getMax(ops)

    println(res.joinToString("\n"))
}
