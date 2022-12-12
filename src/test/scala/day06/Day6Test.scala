package day06

class Day6Test extends munit.FunSuite:

    private val frameSize = 4

    test("part 1 - case 1") {
        assertEquals(Day6.indexOfFirstMarker(frameSize)("mjqjpqmgbljsphdztnvjfqwrcgsmlb"), 7)
    }

    test("part 1 - case 2") {
        assertEquals(Day6.indexOfFirstMarker(frameSize)("bvwbjplbgvbhsrlpgdmjqwftvncz"), 5)
    }

    test("part 1 - case 3") {
        assertEquals(Day6.indexOfFirstMarker(frameSize)("nppdvjthqldpwncqszvftbrmjlhg"), 6)
    }

    test("part 1 - case 4") {
        assertEquals(Day6.indexOfFirstMarker(frameSize)("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"), 10)
    }

    test("part 1 - case 5") {
        assertEquals(Day6.indexOfFirstMarker(frameSize)("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"), 11)
    }