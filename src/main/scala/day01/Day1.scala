package day01

@main def day01(): Unit =
  println(s"Part 1: ${Day1.part1}")
  println(s"Part 2: ${Day1.part2}")

object Day1:
  type Ration = Int
  case class Elf(rations: List[Ration])
  private def parseInput(input: List[String]): List[Elf] = {
    // toInt is safe only because we know the input is valid and well formed
    def stringToRation(s: String): Ration = s.toInt

    case class Accumulator(elves: List[Elf], nextElf: Elf)
    val initialState = Accumulator(List.empty, Elf(List(stringToRation(input.head))))
    val endState = input.tail.foldLeft(initialState) { (acc, next) =>
      if (next == "")
        val nextElves = acc.elves :+ acc.nextElf
        Accumulator(nextElves, Elf(List.empty))
      else
        val nextElf = Elf(acc.nextElf.rations :+ stringToRation(next))
        Accumulator(acc.elves, nextElf)
    }

    endState.elves :+ endState.nextElf
  }

  private val input: List[String] = scala.io.Source.fromResource("day01.txt").getLines.toList
  private val elves = parseInput(input)
  private val rationsPerElf: List[Ration] = elves.map(_.rations.sum)
  val part1: Int = rationsPerElf.max
  val part2: Int = rationsPerElf.sorted.takeRight(3).sum
