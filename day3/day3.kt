package day3

import java.io.File

fun part1() {
    var sum = 0
    File("day3/day3.txt")
        .forEachLine {
            val middle = it.length / 2
            val left = it.substring(0, middle).toSet()
            val right = it.substring(middle).toSet()

            val commonElement = left.intersect(right).first()

            sum += charToInt(commonElement)
        }

    println(sum)
}

fun part2() {
    val listOfSets = mutableListOf(emptySet(), emptySet(), emptySet<Char>())

    var sum = 0
    var index = 0
    File("day3/day3.txt")
        .forEachLine {
            val mod = index % 3

            if (mod == 2) {
                val commonElement = listOfSets[0].intersect(listOfSets[1].intersect(it.toSet())).first()
                sum += charToInt(commonElement)
            }
            listOfSets[mod] = it.toSet()
            index++
        }

    println(sum)
}

private fun charToInt(char: Char): Int {
    return if (char.isUpperCase()) {
        char.code - 38
    } else {
        char.code - 96
    }
}

fun main() {
    part1()
    part2()
}

