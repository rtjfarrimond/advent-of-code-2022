package day02

@main def day02: Unit =
  println(s"Part 1: ${Day2.part1}")
//  println(s"Part 2: ${Day2.part2}")

case class Game(opponentMove: RPS, yourMove: RPS)
object Game:
  def fromString(string: String): Option[Game] =
    for {
      opponentMove <- RPS.fromChar(string.charAt(0))
      yourMove <- RPS.fromChar(string.charAt(2))
    } yield Game(opponentMove, yourMove)

object Day2:

  private val games: Iterator[Game] = scala.io.Source.fromResource("day02.txt")
    .getLines()
    .flatMap(Game.fromString) // I think this will swallow errors, but our input is well formed so it's safe

  val part1: Int = games.map(Scoring.scoreGame).sum
