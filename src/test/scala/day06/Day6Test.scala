package day06

class Day6Test extends munit.FunSuite:

    test("part 1 - case 1") {
        assertEquals(Day6.indexOfFirstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"), 7)
    }

    test("part 1 - case 2") {
        assertEquals(Day6.indexOfFirstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"), 5)
    }

    test("part 1 - case 3") {
        assertEquals(Day6.indexOfFirstMarker("nppdvjthqldpwncqszvftbrmjlhg"), 6)
    }

    test("part 1 - case 4") {
        assertEquals(Day6.indexOfFirstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"), 10)
    }

    test("part 1 - case 5") {
        assertEquals(Day6.indexOfFirstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"), 11)
    }

//    test("part 2".ignore) {
//        assertEquals(Day6.part2, 42)
//    }