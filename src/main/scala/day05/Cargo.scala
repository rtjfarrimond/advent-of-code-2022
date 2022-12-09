package day05

import scala.collection.*
import scala.util.{Failure, Success, Try}

case class Cargo(stacks: Map[Int, mutable.Stack[Char]]):

  def topCrates: String =
    stacks.keys.toList.sorted.map(stacks(_)).map { oneStack =>
      Try(oneStack.top) match
        case Failure(_) => ""
        case Success(char) => char.toString
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