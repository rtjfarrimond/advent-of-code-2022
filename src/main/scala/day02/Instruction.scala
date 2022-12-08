package day02

case class Instruction(opponentMove: Move, outcome: Outcome)
object Instruction:
  def fromString(string: String): Option[Instruction] =
    for {
      opponentMove <- Move.fromChar(string.charAt(0))
      outcome <- Outcome.fromChar(string.charAt(2))
    } yield Instruction(opponentMove, outcome)