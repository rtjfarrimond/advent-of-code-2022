package day07


sealed trait Path {
  def dirName: String = this match
    case directory: Directory => directory match
      case Path.Root => "/"
      case Path.Dir(parent, baseName) => s"${parent.dirName}/$baseName"
    case Path.File(parent, baseName, _) => s"${parent.dirName}/$baseName"
  def baseName: String
}

sealed trait Directory extends Path {
  def parent: Directory
  def ancestors: Set[Directory] =
    Set.unfold(this) { dir =>
      dir match
        case Path.Root => None
        case Path.Dir(parent, _) => Some((parent, parent))
    }
}

object Path {

  case object Root extends Directory {
    override def baseName: String = "/"
    override def parent: Directory = this
  }

  case class File(parent: Directory, baseName: String, size: Long) extends Path
  case class Dir(parent: Directory, baseName: String) extends Directory
}
