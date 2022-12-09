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

  val part1: String = moveCargo(CrateMover9000, cargo, instructions).topCrates

  // TODO: Hide mutability so that this works
//  val part2: String = moveCargo(CrateMover9001, cargo, instructions).topCrates
  val part2: String = moveCargo(CrateMover9001, Cargo.parse(cargoStrings), instructions).topCrates

  private def moveCargo(crateMover: CrateMover, initialCargo: Cargo, instructions: List[Instruction]): Cargo =
    instructions.foldLeft(initialCargo) { (cargo, instruction) =>
      crateMover.move(cargo, instruction)
    }