package u02.ex

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u02.ex.Task2b._

class Task2bTest {
  //es 4
  @Test def testCurrying(): Unit ={
    assertTrue(p1(5)(6)(7))
    assertTrue(p1(6)(6)(6))
    assertFalse(p1(7)(6)(7))

    assertTrue(p2(5,6,7))
    assertTrue(p2(6,6,6))
    assertFalse(p2(7,6,7))

    assertTrue(p3(5)(6)(7))
    assertTrue(p3(6)(6)(6))
    assertFalse(p3(7)(6)(7))

    assertTrue(p4(5,6,7))
    assertTrue(p4(6,6,6))
    assertFalse(p4(7,6,7))
  }

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
