package day4

import java.io.File

fun part1() {
    var sum = 0
    File("day4/day4.txt")
        .forEachLine {
            val pairs = it.split(",")
            val firstNumbers = pairs[0].split("-").map { n -> n.toInt() }.toIntArray()
            val secondNumbers = pairs[1].split("-").map { n -> n.toInt() }.toIntArray()

            if ((firstNumbers[0] <= secondNumbers[0] && firstNumbers[1] >= secondNumbers[1]) ||
                (secondNumbers[0] <= firstNumbers[0] && secondNumbers[1] >= firstNumbers[1]) ) {
                sum++
            }
        }

    println(sum)
}

fun part2() {
    var sum = 0
    File("day4/day4.txt")
        .forEachLine {
            val pairs = it.split(",")
            val firstNumbers = pairs[0].split("-").map { n -> n.toInt() }.toIntArray()
            val secondNumbers = pairs[1].split("-").map { n -> n.toInt() }.toIntArray()

            if (firstNumbers[1] >= secondNumbers[0] && firstNumbers[0] <= secondNumbers[1]){
                sum++
            }
        }

    println(sum)
}

fun main() {
    part1()
    part2()
}

