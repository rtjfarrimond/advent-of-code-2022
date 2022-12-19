package day07

import munit.FunSuite

class DirectoryTest extends FunSuite {

  test("ancestors") {
    val root = Path.Root
    val foo = Path.Dir(root, "foo")
    val bar = Path.Dir(foo, "bar")

    assertEquals(bar.ancestors, Set(root, foo))
  }

}
