package day05

@main def day05(): Unit =
  println(s"Part 1: ${Day5.part1}")
  println(s"Part 2: ${Day5.part2}")

object Day5:

  private val input = scala.io.Source.fromResource("day05.txt").getLines().toList
  private val cargoStrings = input.takeWhile(_ != "")
  private val instructionStrings = input.dropWhile(_ != "").tail

  private val cargo = Cargo.parse(cargoStrings)
  private val instructions = instructionStrings.map(Instruction.fromString)

  val part1: String = solve(CrateMover9000)
  val part2: String = solve(CrateMover9001)

  private def solve(crateMover: CrateMover): String =
    instructions.foldLeft(cargo) { (cargo, instruction) =>
      crateMover.move(cargo, instruction)
    }.topCrates

