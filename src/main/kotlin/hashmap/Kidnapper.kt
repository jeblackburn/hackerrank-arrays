package hashmap

/*
 * Complete the 'checkMagazine' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY magazine
 *  2. STRING_ARRAY note
 */

fun checkMagazine(magazine: Array<String>, note: Array<String>): Boolean {
    val magazineWordCount = HashMap<String, Int>()
    magazine.forEach { m -> magazineWordCount[m] = magazineWordCount.getOrDefault(m, 0) + 1 }
    val result = (note.all { n ->
        val available = magazineWordCount.getOrDefault(n, 0)
        if (available > 0) {
            magazineWordCount[n] = available - 1
            true
        } else {
            false
        }
    })
    println(if(result) {
        "Yes"
    } else {
        "No"
    })
    return result
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

    val note = readLine()!!.trimEnd().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}
