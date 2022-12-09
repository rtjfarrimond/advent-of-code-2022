package day05

import scala.util.matching.Regex

case class Instruction(n: Int, from: Int, to: Int)
object Instruction:
  // Assumes well-formed input
  def fromString(s: String): Instruction =
    val ints = Regex("[\\d]+").findAllMatchIn(s).map(_.toString.toInt).toList
    Instruction(ints(0), ints(1), ints(2))