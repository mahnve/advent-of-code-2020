package dec3

var data = {}.javaClass.getResource("input.txt").openStream().bufferedReader().readLines()

fun main() {
    val runs = listOf(
        1 to 1,
        3 to 1,
        5 to 1,
        7 to 1,
        1 to 2
    )

    val result = runs.map {countHitTrees(data, it.first, it.second)}.reduce {acc, it -> acc * it}

    print(result)

}

private fun countHitTrees(forest: List<String>, stepsRight: Int, stepsDown: Int): Int {
    val result = forest
        .filterIndexed { index, _ -> index % stepsDown == 0 }
        .fold(Pair(0, 0)) { posAndTotal, line ->
            if (hasTree(line, posAndTotal.first))
                Pair(posAndTotal.first + stepsRight, posAndTotal.second + 1)
            else
                Pair(posAndTotal.first + stepsRight, posAndTotal.second)
        }
    return result.second
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

