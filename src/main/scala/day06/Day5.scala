package day06

@main def day06(): Unit =
  println(s"Part 1: ${Day6.part1}")
//  println(s"Part 2: ${Day6.part2}")

object Day6:

  private val input = scala.io.Source.fromResource("day06.txt").getLines().toList

  private case class Frame(data: String) {
    private val uniqueChars: Set[Char] = data.toSet
    private val uniqueCount: Int = uniqueChars.size
    val isStartOfPacketMarker: Boolean = uniqueCount == data.length
  }

  val part1: Int = indexOfFirstMarker(input.head)

  private[day06] def indexOfFirstMarker(buffer: String): Int =
    val frameSize = 4
    val windowedInput = buffer.sliding(size = frameSize)
    val remaining = windowedInput
      .map(Frame.apply)
      .zipWithIndex
      .dropWhile(_._1.isStartOfPacketMarker == false)
    remaining.next()._2 + frameSize
//  val part2: Int = ???