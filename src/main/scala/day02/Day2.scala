package day02

@main def day02(): Unit =
  println(s"Part 1: ${Day2.part1}")
  println(s"Part 2: ${Day2.part2}")

object Day2:

  private val input = scala.io.Source.fromResource("day02.txt").getLines().toList
  val part1: Int = input.flatMap(Game.fromString).map(Scoring.scoreGame).sum
  val part2: Int = input.flatMap(Instruction.fromString).map { instruction =>
      Scoring.score(instruction.outcome, Move.fromInstruction(instruction))
    }.sum
