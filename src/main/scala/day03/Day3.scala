package day03

@main def day03(): Unit =
  println(s"Part 1: ${Day3.part1}")
  println(s"Part 2: ${Day3.part2}")

object Day3:

  type Compartment = String
  private case class Rucksack(compartment1: Compartment, compartment2: Compartment) {
    val all: String = s"$compartment1$compartment2"
  }
  private object Rucksack:
    def fromString(s: String): Rucksack =
      val parts = s.splitAt(s.length / 2)
      Rucksack(parts._1, parts._2)

  private val input = scala.io.Source.fromResource("day03.txt").getLines().toList
  private val rucksacks: List[Rucksack] = input.map(Rucksack.fromString)

  private val lowers = ('a' to 'z').toList
  private val uppers = ('A' to 'Z').toList
  private val chars = lowers ::: uppers
  private val charScores = chars.zipWithIndex.toMap
  private def score(c: Char): Int = charScores(c) + 1

  val part1: Int = rucksacks.map { rucksack =>
    val set1 = rucksack.compartment1.toSet
    val set2 = rucksack.compartment2.toSet
    score((set1 intersect set2).head)
  }.sum

  val part2: Int =
    rucksacks.sliding(3, 3)
      .map { group =>
        group.tail.foldLeft(group.head.all.toSet) { (acc, next) =>
          acc intersect next.all.toSet
        }.head
      }
      .map(score)
      .sum

