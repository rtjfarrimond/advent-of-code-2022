package day05

import munit.FunSuite

import scala.collection._

class CargoTest extends FunSuite:

  private val input = List(
    "    [D]",
    "[N] [C]",
    "[Z] [M] [P]",
    " 1   2   3"
  )

  test("Cargo.parse") {
    val expectedStacks = Map[Int, mutable.Stack[Char]](
      1 -> mutable.Stack.empty[Char].push('Z', 'N'),
      2 -> mutable.Stack.empty[Char].push('M', 'C', 'D'),
      3 -> mutable.Stack.empty[Char].push('P')
    )

    assertEquals(Cargo.parse(input), Cargo(expectedStacks))
  }

  test("Cargo.topCrates") {
    assertEquals(Cargo.parse(input).topCrates, "NDP")
  }