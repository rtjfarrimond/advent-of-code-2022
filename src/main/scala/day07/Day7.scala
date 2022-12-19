package day07

import scala.annotation.tailrec

@main def day07(): Unit =
  println(s"Part 1: ${Day7.part1}")
  println(s"Part 2: ${Day7.part2}")

object Day7:

  private val input = scala.io.Source.fromResource("day07.txt").getLines().toList
  private val instructions = Instruction.parse(input)

  instructions.foreach(println)

  val part1: Long = 42L
  val part2: Long = 42L