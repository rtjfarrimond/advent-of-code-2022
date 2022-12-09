package day05

import munit.FunSuite
import scala.collection._

class CargoTest extends FunSuite:

  test("Cargo.parse") {
    val input = List(
      "    [D]",
      "[N] [C]",
      "[Z] [M] [P]",
      " 1   2   3"
    )

    val expectedStacks = Map[Int, mutable.Stack[Char]](
      1 -> mutable.Stack[Char]('Z', 'N'),
      2 -> mutable.Stack[Char]('M', 'C', 'D'),
      3 -> mutable.Stack[Char]('P')
    )

    assertEquals(Cargo.parse(input), Cargo(expectedStacks))
  }