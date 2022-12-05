package day5

import java.io.File
import java.util.Stack

fun part1() {
    val stack1 = Stack<String>()
    val stack2 = Stack<String>()
    val stack3 = Stack<String>()
    val stack4 = Stack<String>()
    val stack5 = Stack<String>()
    val stack6 = Stack<String>()
    val stack7 = Stack<String>()
    val stack8 = Stack<String>()
    val stack9 = Stack<String>()

    stack1.addAll(mutableListOf("D", "T", "W", "F", "J", "S", "H", "N"))
    stack2.addAll(mutableListOf("H", "R", "P", "Q", "T", "N", "B", "G"))
    stack3.addAll(mutableListOf("L", "Q", "V"))
    stack4.addAll(mutableListOf("N", "B", "S", "W", "R", "Q"))
    stack5.addAll(mutableListOf("N", "D", "F", "T", "V", "M", "B"))
    stack6.addAll(mutableListOf("M", "D", "B", "V", "H", "T", "R"))
    stack7.addAll(mutableListOf("D", "B", "Q", "J"))
    stack8.addAll(mutableListOf("D", "N", "J", "V", "R", "Z", "H", "Q"))
    stack9.addAll(mutableListOf("B", "N", "H", "M", "S"))

    val list = arrayOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9)

    File("day5/day5.txt")
        .forEachLine {
            val data = it.split(" ")
            val howMuch = data[1].toInt()
            val from = data[3].toInt() - 1
            val to = data[5].toInt() - 1

            for (i in 1..howMuch) {
                list[to].push(list[from].pop())
            }
        }

    for (stack in list) {
        print(stack.pop())
    }

}

fun part2() {

    val stack1 = Stack<String>()
    val stack2 = Stack<String>()
    val stack3 = Stack<String>()
    val stack4 = Stack<String>()
    val stack5 = Stack<String>()
    val stack6 = Stack<String>()
    val stack7 = Stack<String>()
    val stack8 = Stack<String>()
    val stack9 = Stack<String>()

    stack1.addAll(mutableListOf("D", "T", "W", "F", "J", "S", "H", "N"))
    stack2.addAll(mutableListOf("H", "R", "P", "Q", "T", "N", "B", "G"))
    stack3.addAll(mutableListOf("L", "Q", "V"))
    stack4.addAll(mutableListOf("N", "B", "S", "W", "R", "Q"))
    stack5.addAll(mutableListOf("N", "D", "F", "T", "V", "M", "B"))
    stack6.addAll(mutableListOf("M", "D", "B", "V", "H", "T", "R"))
    stack7.addAll(mutableListOf("D", "B", "Q", "J"))
    stack8.addAll(mutableListOf("D", "N", "J", "V", "R", "Z", "H", "Q"))
    stack9.addAll(mutableListOf("B", "N", "H", "M", "S"))

    val list = arrayOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9)

    File("day5/day5.txt")
        .forEachLine {
            val data = it.split(" ")
            val howMuch = data[1].toInt()
            val from = data[3].toInt() - 1
            val to = data[5].toInt() - 1

            if (howMuch == 1) {
                list[to].push(list[from].pop())
            } else {
                val popped = arrayOfNulls<String>(howMuch)
                for (i in 1..howMuch) {
                    popped[i-1] = list[from].pop()
                }

                for (i in 1..howMuch) {
                    list[to].push(popped[popped.size-i])
                }

            }
        }

    for (stack in list) {
        print(stack.pop())
    }
}


fun main() {
    part1()
    println()
    part2()
}

