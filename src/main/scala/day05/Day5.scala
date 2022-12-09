package day05

@main def day05(): Unit =
  println(s"Part 1: ${Day5.part1}")
  println(s"Part 2: ${Day5.part2}")

object Day5:

  private val input = scala.io.Source.fromResource("day05.txt").getLines().toList

  case class Instruction(n: Int, from: Int, to: Int)

  val part1: String = "42"
  val part2: String = "42"