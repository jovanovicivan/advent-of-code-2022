package day6

import java.io.File
import java.util.Stack

fun part1() {

    File("day6/day6.txt")
        .forEachLine {
            val c1 = it[0]
            val c2 = it[1]
            val c3 = it[2]
            val c4 = it[3]

            var index = 4

            val charSet = setOf(c1, c2, c3, c4)
            if (charSet.size == 4) {
                println(index)
                return@forEachLine
            }

            for(i in 1..it.length) {
                val newCharSet = setOf(it[i], it[i+1], it[i+2], it[i+3])
                if (newCharSet.size == 4) {
                    println(index+1)
                    return@forEachLine
                }
                index++;
            }
        }
}

fun part2() {

    File("day6/day6.txt")
        .forEachLine {
            val c1 = it[0]
            val c2 = it[1]
            val c3 = it[2]
            val c4 = it[3]
            val c5 = it[4]
            val c6 = it[5]
            val c7 = it[6]
            val c8 = it[7]
            val c9 = it[8]
            val c10 = it[9]
            val c11 = it[10]
            val c12 = it[11]
            val c13 = it[12]
            val c14 = it[13]

            var index = 14

            val charSet = setOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14)
            if (charSet.size == 14) {
                println(index)
                return@forEachLine
            }

            for(i in 1..it.length) {
                val newCharSet = setOf(it[i], it[i+1], it[i+2], it[i+3], it[i+4], it[i+5], it[i+6], it[i+7], it[i+8], it[i+9], it[i+10], it[i+11], it[i+12], it[i+13])
                if (newCharSet.size == 14) {
                    println(index+1)
                    return@forEachLine
                }
                index++;
            }
        }
}

fun main() {
    part1()
    part2()
}

