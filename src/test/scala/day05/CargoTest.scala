package day05

import Day5.Instruction
import munit.FunSuite

import scala.collection.*

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

  test("Cargo.move should move one crate") {
    val initialStack = Cargo.parse(input)
    val instruction: Instruction = Instruction(n = 1, from = 2, to = 1)
    val expectedStacks = Map[Int, mutable.Stack[Char]](
      1 -> mutable.Stack.empty[Char].push('Z', 'N', 'D'),
      2 -> mutable.Stack.empty[Char].push('M', 'C'),
      3 -> mutable.Stack.empty[Char].push('P')
    )

    assertEquals(initialStack.move(instruction).stacks, expectedStacks)
  }

  test("Cargo.move should move multiple crates") {
    val initialStack = Cargo.parse(input)
    val instruction: Instruction = Instruction(n = 2, from = 2, to = 1)
    val expectedStacks = Map[Int, mutable.Stack[Char]](
      1 -> mutable.Stack.empty[Char].push('Z', 'N', 'D', 'C'),
      2 -> mutable.Stack.empty[Char].push('M'),
      3 -> mutable.Stack.empty[Char].push('P')
    )

    assertEquals(initialStack.move(instruction).stacks, expectedStacks)
  }