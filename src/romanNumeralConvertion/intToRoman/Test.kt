package romanNumeralConvertion.intToRoman

import org.junit.Test
import org.junit.Assert.assertEquals


class Test {

    @Test
    fun test1() {
        val input = 3
        val expected = "III"
        assertEquals(expected, IntToRoman().convert(input))
    }

    @Test
    fun test2() {
        val input = 4
        val expected = "IV"
        assertEquals(expected, IntToRoman().convert(input))
    }

    @Test
    fun test3() {
        val input = 9
        val expected = "IX"
        assertEquals(expected, IntToRoman().convert(input))
    }

    @Test
    fun test4() {
        val input = 58
        val expected = "LVIII"
        assertEquals(expected, IntToRoman().convert(input))
    }

    @Test
    fun test5() {
        val input = 1994
        val expected = "MCMXCIV"
        assertEquals(expected, IntToRoman().convert(input))
    }

    @Test
    fun test6() {
        val input = 3999
        val expected = "MMMCMXCIX"
        assertEquals(expected, IntToRoman().convert(input))
    }

}