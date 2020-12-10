package dec2

var data = {}.javaClass.getResource("input.txt").openStream().bufferedReader().readLines()

fun main() {
    val find = data.filter { hasCorrectPassword(it) }
    print(find.size)
    println(find)
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
