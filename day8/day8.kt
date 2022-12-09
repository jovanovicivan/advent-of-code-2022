package day8

import java.io.File

fun part1() {

    val matrix = Array(99) { IntArray(99) }

    var i = 0
    var j = 0
    File("day8/day8.txt")
        .forEachLine {
            if (i > 98 || j > 98) {
                return@forEachLine
            }
            for(char in it) {
                matrix[i][j] = char.digitToInt()
                j++
            }
            i++
            j = 0
        }

    val visibleIndices: MutableSet<Pair<Int, Int>> = mutableSetOf()
    //  Left to right
    for (i in 0..98) {
        var min = -1

        for (j in 0..98) {
          if(matrix[i][j] > min) {
              min = matrix[i][j]
              visibleIndices.add(Pair(i, j))
          }
        }
    }

    //  right to left
    for (i in 0..98) {
        var min = -1

        for (j in 98 downTo 0) {
            if(matrix[i][j] > min) {
                min = matrix[i][j]
                visibleIndices.add(Pair(i, j))
            }
        }
    }

    // top to bottom
    for (i in 0..98) {
        var min = -1

        for (j in 0 .. 98) {
            if(matrix[j][i] > min) {
                min = matrix[j][i]
                visibleIndices.add(Pair(j, i))
            }
        }
    }

    // bottom to top
    for (i in 0..98) {
        var min = -1

        for (j in 98 downTo  0) {
            if(matrix[j][i] > min) {
                min = matrix[j][i]
                visibleIndices.add(Pair(j, i))
            }
        }
    }

    println(visibleIndices.size)
}


val size = 99

fun part2() {

    val matrix = Array(size) { IntArray(size) }

    var i = 0
    var j = 0
    File("day8/day8.txt")
        .forEachLine {
            if (i > size-1 || j > size-1) {
                return@forEachLine
            }
            for(char in it) {
                matrix[i][j] = char.digitToInt()
                j++
            }
            i++
            j = 0
        }

    var score = 1.0
    for (i in 0..size-1) {
        for (j in 0..size-1) {
            val calculatedScore = calculateScore(i, j, matrix)
            if (calculatedScore > score) {
                score = calculatedScore
            }
        }
    }

    println(score)
}

fun calculateScore(i: Int, j: Int, matrix: Array<IntArray>): Double {

    val currentElement = matrix[i][j]

    var score = 1.0
    // to right
    var numElements = 0
    for (index in j..size-1) {
        if (index != j) {
            if (currentElement > matrix[i][index] ) {
                numElements++
            } else if (currentElement <= matrix[i][index] ) {
                numElements++
                break
            }
        }
    }
    score *= numElements
    numElements = 0

    // to left
    for (index in j downTo 0) {
        if (index != j) {
            if (currentElement > matrix[i][index] ) {
                numElements++
            } else if (currentElement <= matrix[i][index] ) {
                numElements++
                break
            }
        }
    }
    score *= numElements
    numElements = 0

    // to bottom
    for (index in i .. size-1) {
        if (index != i) {
            if (currentElement > matrix[index][j] ) {
                numElements++
            } else if (currentElement <= matrix[index][j] ) {
                numElements++
                break
            }
        }
    }
    score *= numElements
    numElements = 0

    // to top
    for (index in i downTo 0) {
        if (index != i) {
            if (currentElement > matrix[index][j] ) {
                numElements++
            } else if (currentElement <= matrix[index][j] ) {
                numElements++
                break
            }
        }
    }
    score *= numElements
    return score

}


fun main() {
    part1()
    part2()
}

