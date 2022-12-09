package day05

import scala.annotation.tailrec

private sealed trait CrateMover:
  def move(cargo: Cargo, instruction: Instruction): Cargo

object CrateMover9000 extends CrateMover:
  override def move(cargo: Cargo, instruction: Instruction): Cargo =
    (1 to instruction.n).foldLeft(cargo) { (acc, _) =>
      acc.stacks(instruction.from).lastOption match
        case None =>
          acc
        case Some(char) =>
          val newToStack = acc.stacks(instruction.to) appended char
          val newFromStack = acc.stacks(instruction.from).dropRight(1)
          Cargo {
            acc.stacks
              .updated(instruction.from, newFromStack)
              .updated(instruction.to, newToStack)
          }
    }

object CrateMover9001 extends CrateMover:
  override def move(cargo: Cargo, instruction: Instruction): Cargo =
    val cratesToMove = cargo.stacks(instruction.from).takeRight(instruction.n)
    val newFromStack = cargo.stacks(instruction.from).dropRight(instruction.n)
    val newToStack = cargo.stacks(instruction.to) ::: cratesToMove
    Cargo {
      cargo.stacks
        .updated(instruction.from, newFromStack)
        .updated(instruction.to, newToStack)
    }