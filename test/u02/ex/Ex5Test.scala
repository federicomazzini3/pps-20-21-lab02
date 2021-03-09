package u02.ex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.ex.Ex5._

class Ex5Test {
  //es 5
  @Test def testFunctionalComposition(): Unit ={
    def compose(f: Int => Int, g: Int => Int)(x:Int): Int = f(g(x))
    assertEquals(9, compose(_-1, _*2)(5))
  }

  @Test def testFunctionalCompositionWithGenerics(): Unit ={
    def reverseString(s:String): String = s.reverse
    def minus1(n:Int) = n - 1
    def mult2(n:Int) = n * 2
    assertEquals("olleh", reverseString("hello"))
    assertEquals(9, composeGenerics(minus1, mult2)(5))
    assertEquals("hello", composeGenerics(reverseString, reverseString)("hello"))
  }
}
