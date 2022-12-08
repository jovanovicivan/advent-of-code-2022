package day7

import java.io.File


class Node {
    var data: String = ""
    var parent: Node? = null
    var children: MutableSet<Node> = mutableSetOf()
    var size: Int = 0
}

class Tree(rootData: String) {
    val root: Node = Node()

    init {
        root.data = rootData
    }

}


fun part1() {

    val tree = Tree("/")
    var currentNode: Node? = Node()


    File("day7/day7.txt")
        .forEachLine {
            if (it.equals("$ cd /")) {
                currentNode = tree.root
            } else if (it.equals("$ ls")) {
                // do nothing
            } else if (it[0].isDigit()) {
                val size = it.split(" ")[0].toInt()
                currentNode?.size = currentNode?.size?.plus(size)!!
            } else if (it.startsWith("dir")) {
                val node = Node()
                node.data = it.split(" ")[1]
                node.parent = currentNode
                currentNode?.children?.add(node)
            } else if (it.startsWith("$ cd ") && !it.equals("$ cd /") && !it.equals("$ cd ..")) {
                currentNode = currentNode?.children?.first { e -> e.data.equals(it.split(" ")[2])}
            } else if (it.equals("$ cd ..")) {
                currentNode = currentNode?.parent
            }
        }


    printSize(tree.root)
    println(sizes)
}

var sizes = 0
var allDirs = mutableMapOf<String, Int>()
var rootSize = 0
fun printSize(node: Node): Int {
    val totalSize = node.size + node.children.map { printSize(it) }.sum()
    if (totalSize <= 100000) sizes += totalSize
    if (node.data.equals("/")) {
        rootSize = totalSize
    }

    allDirs.put(node.data, totalSize)

    //println(node.data + " " + totalSize)
    return totalSize
}

fun part2() {
    val tree = Tree("/")
    var currentNode: Node? = Node()


    File("day7/day7.txt")
        .forEachLine {
            if (it.equals("$ cd /")) {
                currentNode = tree.root
            } else if (it.equals("$ ls")) {
                // do nothing
            } else if (it[0].isDigit()) {
                val size = it.split(" ")[0].toInt()
                currentNode?.size = currentNode?.size?.plus(size)!!
            } else if (it.startsWith("dir")) {
                val node = Node()
                node.data = it.split(" ")[1]
                node.parent = currentNode
                currentNode?.children?.add(node)
            } else if (it.startsWith("$ cd ") && !it.equals("$ cd /") && !it.equals("$ cd ..")) {
                currentNode = currentNode?.children?.first { e -> e.data.equals(it.split(" ")[2])}
            } else if (it.equals("$ cd ..")) {
                currentNode = currentNode?.parent
            }
        }

    printSize(tree.root)

    val toDelete = 30_000_000 - (70_000_000 - rootSize)

    println("Need to delete: " + toDelete)
}


fun main() {
    part1()
    part2()
}

