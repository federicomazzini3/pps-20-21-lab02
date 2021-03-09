package u02.ex

import org.junit.jupiter.api.Assertions.{assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u02.ex.Ex4._

object Ex4Test {
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
}
