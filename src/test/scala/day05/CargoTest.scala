package day05

import munit.FunSuite

class CargoTest extends FunSuite:

  private val input = List(
    "    [D]",
    "[N] [C]",
    "[Z] [M] [P]",
    " 1   2   3"
  )

  test("Cargo.parse") {
    val expectedStacks = Map[Int, List[Char]](
      1 -> List('Z', 'N'),
      2 -> List('M', 'C', 'D'),
      3 -> List('P')
    )

    assertEquals(Cargo.parse(input), Cargo(expectedStacks))
  }

  test("Cargo.topCrates") {
    assertEquals(Cargo.parse(input).topCrates, "NDP")
  }