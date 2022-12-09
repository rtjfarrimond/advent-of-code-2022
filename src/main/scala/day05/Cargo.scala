package day05

case class Cargo(stacks: Map[Int, List[Char]]):

  def topCrates: String =
    stacks.keys.toList.sorted.map(stacks(_)).map { oneStack =>
      oneStack.lastOption match
        case None => ""
        case Some(char) => char.toString
    }.mkString

object Cargo:
  // Assumes well-formed input
  def parse(lines: List[String]): Cargo =
    val keys = lines.last.replace(" ", "").map(_.toString.toInt)

    val initialStack = keys.map(_ -> List.empty[Char]).toMap
    val stacks = lines.dropRight(1).reverse.foldLeft(initialStack) { (acc, next) =>
      (1 to next.length by 4).map(next(_)).zipWithIndex.foldLeft(acc) { (acc, next) =>
        next match
          case (char, idx) if char != ' ' =>
            val mapKey = idx + 1
            val stack = acc(mapKey)
            val updatedStack = stack appended char
            acc.updated(mapKey, updatedStack)
          case _ =>
            acc
      }
    }

    Cargo(stacks)