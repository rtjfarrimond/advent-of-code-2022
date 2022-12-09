package day04

case class Pair(range1: Range, range2: Range) {
  private val set1 = range1.toSet
  private val set2 = range2.toSet
  val contained: Boolean = (set1 intersect set2).size == scala.math.min(set1.size, set2.size)
}

private object Pair:

  // Assumes well-formed input
  def fromString(s: String): Pair =
    val ranges = s.split(',').map(parseToFrom)
    Pair(ranges(0), ranges(1))

  private def parseToFrom(s: String): Range.Inclusive =
    val toFrom = s.split('-').map(_.toInt)
    toFrom(0) to toFrom(1)
