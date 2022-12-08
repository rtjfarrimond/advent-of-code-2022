package day02

case class Game(opponentMove: Move, yourMove: Move)
object Game:
  def fromString(string: String): Option[Game] =
    for {
      opponentMove <- Move.fromChar(string.charAt(0))
      yourMove <- Move.fromChar(string.charAt(2))
    } yield Game(opponentMove, yourMove)