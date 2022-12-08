package day02

sealed trait Move:
  def beats: Move

object Move:
  case object Rock extends Move:
    override val beats = Scissors
  case object Paper extends Move:
    override val beats = Rock
  case object Scissors extends Move:
    override val beats = Paper

  def fromChar(char: Char): Option[Move] = char match
    case c if Set('A', 'X').contains(c) =>
      Some(Rock)
    case c if Set('B', 'Y').contains(c) =>
      Some(Paper)
    case c if Set('C', 'Z').contains(c) =>
      Some(Scissors)
    case _ => None

  def fromInstruction(instruction: Instruction): Move =
    instruction.outcome match
      case Outcome.Win =>
        instruction.opponentMove match
          case Rock => Paper
          case Paper => Scissors
          case Scissors => Rock
      case Outcome.Lose => instruction.opponentMove.beats
      case Outcome.Draw => instruction.opponentMove
