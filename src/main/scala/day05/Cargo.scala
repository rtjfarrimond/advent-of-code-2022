package day05

import scala.collection.*
import scala.util.{Failure, Success, Try}

case class Cargo(stacks: Map[Int, mutable.Stack[Char]]):
  def move(instruction: Instruction): Cargo =
    (0 until instruction.n).map { _ =>
      val toStack = stacks(instruction.to)
      Try(stacks(instruction.from).pop()) match
        case Failure(_) =>
          toStack
        case Success(char) =>
          toStack.push(char)
    }
    this

  def topCrates: String =
    stacks.keys.toList.sorted.map(stacks(_)).map { oneStack =>
      oneStack.top
    }.mkString

object Cargo:
  // Assumes well-formed input
  def parse(lines: List[String]): Cargo =
    val keys = lines.last.replace(" ", "").map(_.toString.toInt)

    val initialStack = keys.map(_ -> mutable.Stack.empty[Char]).toMap
    val stacks = lines.dropRight(1).reverse.foldLeft(initialStack) { (acc, next) =>
      (1 to next.length by 4).map(next(_)).zipWithIndex.map {
        case (char, idx) if char != ' ' =>
          acc(idx + 1).push(char)
        case _ =>
          acc
      }
      acc
    }

    Cargo(stacks)