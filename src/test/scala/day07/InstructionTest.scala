package day07

import Instruction.FileDescriptor
import munit.FunSuite

class InstructionTest extends FunSuite {

  test("parse") {

    val input = List(
      "$ cd /",
      "$ ls",
      "dir a",
      "14848514 b.txt",
      "8504156 c.dat",
      "dir d",
      "$ cd a"
    )
    val expectedFileDescriptors: Set[FileDescriptor] = Set(
      FileDescriptor(14848514L, "b.txt"),
      FileDescriptor(8504156L, "c.dat")
    )
    val expected = List(
      Instruction.Cd("/"),
      Instruction.Ls(Set("a", "d"), expectedFileDescriptors),
      Instruction.Cd("a")
    )

    assertEquals(Instruction.parse(input), expected)

  }

}
