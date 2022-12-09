package day05

import munit.FunSuite

class InstructionTest extends FunSuite:

  test("Instruction.fromString") {
    assertEquals(Instruction.fromString("move 1 from 2 to 1"), Instruction(1, 2, 1))
  }

  test("Instruction.fromString with double digits") {
    assertEquals(Instruction.fromString("move 11 from 4 to 2"), Instruction(11, 4, 2))
  }