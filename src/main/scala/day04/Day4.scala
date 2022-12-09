package day04

@main def day04(): Unit =
  println(s"Part 1: ${Day4.part1}")
  println(s"Part 2: ${Day4.part2}")

object Day4:

  private val input = scala.io.Source.fromResource("day04.txt").getLines().toList
  private val pairs = input.map(Pair.fromString)

  val part1: Int = pairs.count(_.contained)

  val part2: Int = 42

