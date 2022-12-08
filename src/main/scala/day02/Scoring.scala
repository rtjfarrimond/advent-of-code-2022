package day02

object Scoring:

  def scoreGame(game: Game): Int =
    val outcome = Outcome.ofGame(game)
    val yourMove = game.yourMove
    Scoring.scoreRps(yourMove) + Scoring.scoreOutcome(outcome)

  private def scoreRps(rps: RPS): Int =
    rps match
      case RPS.Rock => 1
      case RPS.Paper => 2
      case RPS.Scissors => 3

  private def scoreOutcome(outcome: Outcome): Int =
    outcome match
      case Outcome.Win => 6
      case Outcome.Lose => 0
      case Outcome.Draw => 3