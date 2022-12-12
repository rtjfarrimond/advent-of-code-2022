package day06

@main def day06(): Unit =
  println(s"Part 1: ${Day6.part1}")
  println(s"Part 2: ${Day6.part2}")

object Day6:

  private val input = scala.io.Source.fromResource("day06.txt").getLines().toList

  val part1: Int = indexOfFirstStartOfPacketMarker(input.head)
  val part2: Int = indexOfFirstStartOfMessageMarker(input.head)

  private def indexOfFirstStartOfPacketMarker(buffer: String): Int =
    indexOfFirstMarker(frameSize = 4)(buffer)

  private def indexOfFirstStartOfMessageMarker(buffer: String): Int =
    indexOfFirstMarker(frameSize = 14)(buffer)

  private[day06] def indexOfFirstMarker(frameSize: Int)(buffer: String): Int =
    buffer.sliding(size = frameSize)
      .zipWithIndex
      .dropWhile { (frame, _) =>
        frame.toSet.size != frame.length
      }
      .next()
      ._2 + frameSize