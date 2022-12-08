package day02

sealed trait Outcome
object Outcome:
  case object Win extends Outcome
  case object Lose extends Outcome
  case object Draw extends Outcome

  def ofGame(game: Game): Outcome =
    if (game.opponentMove == game.yourMove) Draw
    else if (game.opponentMove.beats == game.yourMove) Lose
    else Win

  def fromChar(char: Char): Option[Outcome] =
    char match
      case 'X' => Some(Lose)
      case 'Y' => Some(Draw)
      case 'Z' => Some(Win)
      case _ => None
