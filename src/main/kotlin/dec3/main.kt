package dec3

var data = {}.javaClass.getResource("input.txt").openStream().bufferedReader().readLines()

fun main() {
    val result = data.fold(Pair(0, 0)) { posAndTotal, line ->
        if (hasTree(line, posAndTotal.first))
            Pair(posAndTotal.first + 3, posAndTotal.second + 1)
        else
            Pair(posAndTotal.first + 3, posAndTotal.second)
    }

    print(result.second)

}

fun hasTree(line: String, position: Int): Boolean {
    return makeLineLongEnough(line, position)[position] == '#'
}

fun makeLineLongEnough(line: String, position: Int): String {
    return if (position < line.length)
        line
    else
        makeLineLongEnough(line + line, position)
}

