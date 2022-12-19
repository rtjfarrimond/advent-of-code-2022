package day07

import Path._

case class DirectoryMetadata(totalSize: Long, contents: Set[Path])

case class FileSystem(workingDirectory: Directory, database: Map[Directory, DirectoryMetadata], totalSpace: Long) {

  val remainingSpace: Long = totalSpace - database(Root).totalSize

  def interpret(instruction: Instruction): FileSystem =
    instruction match
      case Instruction.Cd("/") =>
        FileSystem(Root, database, totalSpace)
      case Instruction.Cd("..") =>
        FileSystem(workingDirectory.parent, database, totalSpace)
      case Instruction.Cd(target) =>
        FileSystem(Dir(workingDirectory, target), database, totalSpace)
      case Instruction.Ls(subDirNames, fileDescriptors) =>
        val subDirs: Set[Directory] = subDirNames.map(Dir(workingDirectory, _))
        val files = fileDescriptors.map { fd =>
          File(workingDirectory, fd.name, fd.size)
        }
        val totalFileSize = files.map(_.size).sum
        val ancestors = workingDirectory.ancestors
        val recordsToUpsert = getRecordsToUpsert(ancestors, subDirs, totalFileSize)
        val updatedDatabase = recordsToUpsert.foldLeft(database) { (db, record) =>
          db.updated(record._1, record._2)
        }
        FileSystem(workingDirectory, updatedDatabase, totalSpace)

  private def getRecordsToUpsert(ancestors: Set[Directory], subDirs: Set[Directory], totalFileSize: Long): Set[(Directory, DirectoryMetadata)] = {
    val inserts = subDirs.map { sd =>
      sd -> DirectoryMetadata(0L, Set.empty)
    }
    val updates = ancestors.incl(workingDirectory).map { dir =>
      val currentMetadata = database(dir)
      dir -> DirectoryMetadata(currentMetadata.totalSize + totalFileSize, currentMetadata.contents)
    }
    inserts union updates
  }

}

object FileSystem {
  def empty(totalSpace: Long) = FileSystem(Root, Map(Root -> DirectoryMetadata(0, Set.empty)), totalSpace)
}
