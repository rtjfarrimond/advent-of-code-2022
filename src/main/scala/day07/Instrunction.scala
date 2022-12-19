package day07

import scala.annotation.tailrec


sealed trait Instruction
object Instruction {
  case class FileDescriptor(size: Long, name: String)
  case class Cd(target: String) extends Instruction
  case class Ls(subDirNames: Set[String], fileDescriptors: Set[FileDescriptor]) extends Instruction

  def parse(strings: List[String]): List[Instruction] =
    @tailrec
    def loop(acc: List[Instruction], rest: List[String]): List[Instruction] = {
      rest match
        case Nil => acc
        case head :: tail =>
          val parts = head.split(' ')
          if (parts(1) == "cd")
            loop(acc :+ Cd(parts(2)), tail)
          else if (parts(1) == "ls")
            val children = tail.takeWhile(s => s(0) != '$')
            val (dirStrings, fileStrings) = children.partition(_.startsWith("dir"))
            val subDirs = dirStrings.map(_.replace("dir ", "")).toSet
            val fileDescriptors = fileStrings.map { s =>
              val split = s.split(' ')
              FileDescriptor(split(0).toLong, split(1))
            }.toSet
            val ls = Ls(subDirs, fileDescriptors)
            loop(acc :+ ls, tail.drop(children.length))
          else throw new RuntimeException("Input was not one of cd or ls")
    }
    loop(Nil, strings)

}