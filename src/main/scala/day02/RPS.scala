package day02

sealed trait RPS:
  def beats: RPS

object RPS:
  case object Rock extends RPS:
    override val beats = Scissors
  case object Paper extends RPS:
    override val beats = Rock
  case object Scissors extends RPS:
    override val beats = Paper

  def fromChar(char: Char): Option[RPS] = char match
    case c if Set('A', 'X').contains(c) =>
      Some(Rock)
    case c if Set('B', 'Y').contains(c) =>
      Some(Paper)
    case c if Set('C', 'Z').contains(c) =>
      Some(Scissors)
    case _ => None
