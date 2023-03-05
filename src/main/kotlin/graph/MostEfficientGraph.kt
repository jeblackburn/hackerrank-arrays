package graph

import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'roadsAndLibraries' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER c_lib
 *  3. INTEGER c_road
 *  4. 2D_INTEGER_ARRAY cities
 */

fun roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: Array<Array<Int>>): Long {
    if (c_lib <= c_road) return (c_lib * n).toLong()
    val allCities = 1.rangeTo(n).toMutableSet()
    val adjacencyMap = HashMap<Int, HashSet<Int>>()
    var necessaryRoads = 0
    cities.forEach { connection ->
        necessaryRoads++
        adjacencyMap.getOrPut(connection[0]) { HashSet() }.add(connection[1])
        adjacencyMap.getOrPut(connection[1]) { HashSet() }.add(connection[0])
    }
    var libraryCount = 1
    val reachableNodes = findConnected(adjacencyMap, cities[0][0], HashSet())
    val remainingCities = HashSet(allCities - reachableNodes)
    while (remainingCities.isNotEmpty()) {
        libraryCount++
        val moreCities = findConnected(adjacencyMap, remainingCities.first(), HashSet())
        remainingCities.removeAll(moreCities)
    }
    return (c_lib * libraryCount + c_road * necessaryRoads).toLong()
}

fun findConnected(
    adjacencyMap: java.util.HashMap<Int, java.util.HashSet<Int>>,
    start: Int,
    seen: HashSet<Int>
): HashSet<Int> {
    seen.add(start)
    val neighbors: HashSet<Int> = adjacencyMap.computeIfAbsent(start) { HashSet() }
    val unseen: Set<Int> = neighbors - seen
    seen.addAll(neighbors)
    unseen.forEach { newNeighbor -> findConnected(adjacencyMap, newNeighbor, seen) }
    return seen
}

fun canReach(adjacencyMap: HashMap<Int, HashSet<Int>>, from: Int, dest: Int, touched: HashSet<Int>): Boolean {
    val neighbors: HashSet<Int> = adjacencyMap.computeIfAbsent(from) { HashSet() }
    if (dest in neighbors) {
        return true
    } else {
        val untouchedNeighbors = neighbors - touched
        return if (untouchedNeighbors.isEmpty()) {
            false
        } else {
            touched.addAll(neighbors)
            untouchedNeighbors.all { n -> canReach(adjacencyMap, n, dest, touched) }
        }
    }
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val c_lib = first_multiple_input[2].toInt()

        val c_road = first_multiple_input[3].toInt()

        val cities = Array<Array<Int>>(m, { Array<Int>(2, { 0 }) })

        for (i in 0 until m) {
            cities[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        }

        val result = roadsAndLibraries(n, c_lib, c_road, cities)

        println(result)
    }
}
