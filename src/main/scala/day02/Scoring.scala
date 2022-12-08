package day02

object Scoring:

  def score(outcome: Outcome, yourMove: Move): Int =
    Scoring.scoreRps(yourMove) + Scoring.scoreOutcome(outcome)

  def scoreGame(game: Game): Int =
    score(Outcome.ofGame(game), game.yourMove)

  private def scoreRps(rps: Move): Int =
    rps match
      case Move.Rock => 1
      case Move.Paper => 2
      case Move.Scissors => 3

  private def scoreOutcome(outcome: Outcome): Int =
    outcome match
      case Outcome.Win => 6
      case Outcome.Lose => 0
      case Outcome.Draw => 3