package day05

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

private sealed trait CrateMover:
  def move(cargo: Cargo, instruction: Instruction): Cargo

object CrateMover9000 extends CrateMover:
  override def move(cargo: Cargo, instruction: Instruction): Cargo =
    (0 until instruction.n).map { _ =>
      val toStack = cargo.stacks(instruction.to)
      Try(cargo.stacks(instruction.from).pop()) match
        case Failure(_) =>
          toStack
        case Success(char) =>
          toStack.push(char)
    }
    cargo

object CrateMover9001 extends CrateMover:
  override def move(cargo: Cargo, instruction: Instruction): Cargo =
    val crates = (0 until instruction.n).foldLeft(List.empty[Char]) { (acc, _) =>
      Try(cargo.stacks(instruction.from).pop()) match
        case Failure(_) =>
          acc
        case Success(char) =>
          acc prepended char
    }
    cargo.stacks(instruction.to).pushAll(crates)
    cargo