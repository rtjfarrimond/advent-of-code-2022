package day07

import scala.annotation.tailrec

@main def day07(): Unit =
  println(s"Part 1: ${Day7.part1}")
  println(s"Part 2: ${Day7.part2}")

object Day7:

  private val input = scala.io.Source.fromResource("day07.txt").getLines().toList
  private val instructions = Instruction.parse(input)
  private val fileSystem = instructions.foldLeft(FileSystem.empty) { (fs, instruction) =>
    fs.interpret(instruction)
  }
  private val candidates = fileSystem.database.filter { (_, metadata) =>
    metadata.totalSize <= 100000L
  }

  val part1: Long = candidates.values.map(_.totalSize).sum
  val part2: Long = 42L