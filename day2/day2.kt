package day2

import java.io.File

fun part1() {

    val map = mapOf('A' to 1, 'B' to 2, 'C' to 3, 'X' to 1, 'Y' to 2, 'Z' to 3)

    var totalScore = 0
    File("day2/day2.txt")
        .forEachLine {
            val myChoice = map[it[2]]
            val oponentChoice = map[it[0]]

            if (myChoice != null) {
                totalScore += myChoice
            }

            if (myChoice == oponentChoice) {
                totalScore += 3
            } else if (
                (oponentChoice == 1 && myChoice == 2) ||
                (oponentChoice == 2 && myChoice == 3) ||
                (oponentChoice == 3 && myChoice == 1))
                totalScore += 6
        }

    println(totalScore)
}

fun part2() {

    val map = mapOf('A' to 1, 'B' to 2, 'C' to 3, 'X' to 1, 'Y' to 2, 'Z' to 3)
    val mapOfResults = mapOf('X' to 0, 'Y' to 3, 'Z' to 6)

    var totalScore = 0
    File("day2/day2.txt")
        .forEachLine {
            val oponentChoice = map[it[0]]
            val results = mapOfResults[it[2]]

            if (oponentChoice != null) {
                when (results) {
                    3 -> {
                        totalScore += oponentChoice
                    }
                    0 -> {
                        when (oponentChoice) {
                            1 -> totalScore += 3
                            2 -> totalScore += 1
                            3 -> totalScore += 2
                        }
                    }
                    6 -> {
                        when (oponentChoice) {
                            1 -> totalScore += 2
                            2 -> totalScore += 3
                            3 -> totalScore += 1
                        }
                    }
                }
            }

            if (results != null) {
                totalScore += results
            }

        }

    println(totalScore)
}


fun main() {
    part1()
    part2()
}

