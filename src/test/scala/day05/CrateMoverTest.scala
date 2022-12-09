package day05

import munit.FunSuite

class CrateMoverTest extends FunSuite:

  private val input = List(
    "    [D]",
    "[N] [C]",
    "[Z] [M] [P]",
    " 1   2   3"
  )

  test("CrateMover9000 should move a single crate") {
    val cargo = Cargo.parse(input)
    val instruction = Instruction(n = 1, from = 2, to = 1)

    val expectedAsStrings = List(
      "[D]",
      "[N] [C]",
      "[Z] [M] [P]",
      " 1   2   3"
    )

    assertEquals(CrateMover9000.move(cargo, instruction), Cargo.parse(expectedAsStrings))
  }

  test("CrateMover9000 should move multiple crates") {
    val cargo = Cargo.parse(input)
    val instruction = Instruction(n = 2, from = 2, to = 1)

    val expectedAsStrings = List(
      "[C]",
      "[D]",
      "[N]",
      "[Z] [M] [P]",
      " 1   2   3"
    )

    assertEquals(CrateMover9000.move(cargo, instruction), Cargo.parse(expectedAsStrings))
  }

  test("CrateMover9001 should move a single crate") {
    val cargo = Cargo.parse(input)
    val instruction = Instruction(n = 1, from = 2, to = 1)

    val expectedAsStrings = List(
      "[D]",
      "[N] [C]",
      "[Z] [M] [P]",
      " 1   2   3"
    )

    assertEquals(CrateMover9001.move(cargo, instruction), Cargo.parse(expectedAsStrings))
  }

  test("CrateMover9001 should move multiple crates") {
    val cargo = Cargo.parse(input)
    val instruction = Instruction(n = 2, from = 2, to = 1)

    val expectedAsStrings = List(
      "[D]",
      "[C]",
      "[N]",
      "[Z] [M] [P]",
      " 1   2   3"
    )

    assertEquals(CrateMover9001.move(cargo, instruction), Cargo.parse(expectedAsStrings))
  }