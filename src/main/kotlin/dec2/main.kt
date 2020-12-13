package dec2

var data = {}.javaClass.getResource("input.txt").openStream().bufferedReader().readLines()

fun main() {
    val find = data.filter { hasCharacterInOneOfPositions(it) }
    print(find.size)
    println(find)
}

fun hasCharacterInOneOfPositions(line: String): Boolean {
    val (positionsString, characterString, password) = line.split(" ")
    val positions = extractPositions(positionsString)
    val character = characterString.toCharArray()[0]
    return hasOneAndOnlyOneMatch(password, character, positions)
}

fun hasOneAndOnlyOneMatch(password: String, character: Char, positions: Pair<Int, Int>): Boolean {
    val hasOnFirst = password[positions.first -1] == character
    val hasOnSecond = password[positions.second -1] == character
    return hasOnFirst.xor(hasOnSecond)
}

fun extractPositions(positionsString: String): Pair<Int, Int> {
    val (firstString, secondString) = positionsString.split("-")
    return Pair(firstString.toInt(), secondString.toInt())
}

fun hasCorrectPassword(line: String) :Boolean {
    val (rangeString, characterString, password) = line.split(" ")
    val character = characterString.toCharArray()[0]
    val range = extractRange(rangeString)
    return inRange(password, character, range)

}

fun inRange(password: String, character: Char, range: IntRange): Boolean {
    val count = password.fold(0) { sum, item ->
        if (item == character)
            sum + 1
        else
            sum

    }
    return range.contains(count)
}


fun extractRange(rangeString: String): IntRange {
    val(lowerString, upperString) = rangeString.split("-")
    return IntRange(lowerString.toInt(), upperString.toInt())
}
