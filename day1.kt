import java.io.File

fun part1() {
    var max = 0
    var maxSoFar = 0
    File("day1.txt")
        .forEachLine {
            if (it.isEmpty()) {
                if (maxSoFar > max) {
                    max = maxSoFar
                }
                maxSoFar = 0
            } else {
                maxSoFar += it.toInt()
            }
        }
    println(max)
}

fun part2() {
    val arrayOfMaxNumbers = intArrayOf(0, 0, 0)
    var minimumElementIndex = 0
    var maxSoFar = 0
    File("day1.txt")
        .forEachLine {
            if (it.isEmpty()) {
                if (maxSoFar > arrayOfMaxNumbers[minimumElementIndex]) {
                    arrayOfMaxNumbers[minimumElementIndex] = maxSoFar
                    minimumElementIndex = arrayOfMaxNumbers.indexOf(arrayOfMaxNumbers.min())
                }
                maxSoFar = 0
            } else {
                maxSoFar += it.toInt()
            }
        }
    println(arrayOfMaxNumbers.sum())
}

fun main() {
    part1()
    part2()
}

