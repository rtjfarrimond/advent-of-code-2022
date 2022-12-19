package day07

import scala.annotation.tailrec

@main def day07(): Unit =
  println(s"Part 1: ${Day7.part1}")
  println(s"Part 2: ${Day7.part2}")

object Day7:

  private val input = scala.io.Source.fromResource("day07.txt").getLines().toList
  private val instructions = Instruction.parse(input)
  private val totalSpace = 70000000L
  private val fileSystem = instructions.foldLeft(FileSystem.empty(totalSpace)) { (fs, instruction) =>
    fs.interpret(instruction)
  }
  private val candidates = fileSystem.database.filter { (_, metadata) =>
    metadata.totalSize <= 100000L
  }

  val part1: Long = candidates.values.map(_.totalSize).sum
  val part2: Long = {
    val requiredSpace = 30000000L
    val additionalSpaceNeeded = requiredSpace - fileSystem.remainingSpace
    val filteredCandidates = fileSystem.database.collect {
      case (_, metadata) if metadata.totalSize > additionalSpaceNeeded =>
        metadata
    }
    val sortedCandidates = filteredCandidates.toList.sorted { (metadata1, metadata2) =>
      metadata1.totalSize compare metadata2.totalSize
    }
    val smallest = sortedCandidates.head
    smallest.totalSize
  }