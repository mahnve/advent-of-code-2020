package dec1

var data = {}.javaClass.getResource("input.txt").openStream().bufferedReader().readLines().map { it.toInt() }

fun main() {
    for (first in data) {
        for (second in data) {
            if ((first + second) == 2020) {

                println(String.format("%s * %s = %s", first, second, first * second));
            }
        }
    }
}

fun three() {
    for (first in data) {
        for (second in data) {
            for (third in data) {
                if ((first + second + third) == 2020) {

                    println(String.format("%s * %s * %s = %s", first, second, third,  first * second*third));
                }
            }
        }
    }
}