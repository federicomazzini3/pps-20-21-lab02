package u02.ex

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u02.ex.Ex3._

object Ex3Test {
  //es3
  @Test def testParity(){
    assertEquals("even", parityWithDef(4))
    assertEquals("odd", parityWithDef(5))
  }

  //es 3.b
  @Test def testEmpty(): Unit ={
    val empty1: String => Boolean = (s:String) =>  (s == "")
    val empty2: String => Boolean = _ == ""
    val empty3 = (s:String) => s==""

    assertTrue(empty1(""))
    assertFalse(empty1("a"))
    assertTrue(empty2(""))
    assertFalse(empty2("a"))
    assertTrue(empty3(""))
    assertFalse(empty3("a"))
  }

  @Test def testNotEmpty(): Unit ={
    val empty: String => Boolean = (s:String) =>  (s == "")

    val notEmpty1 = neg1(empty)
    val notEmpty2 = neg2(empty)
    val notEmpty3 = neg3(empty)
    val notEmpty4 = neg4(empty)

    assertFalse(notEmpty1(""))
    assertTrue(notEmpty1("a"))
    assertFalse(notEmpty2(""))
    assertTrue(notEmpty2("a"))
    assertFalse(notEmpty3(""))
    assertTrue(notEmpty3("a"))
    assertFalse(notEmpty4(""))
    assertTrue(notEmpty4("a"))
  }

  //es 3.c
  @Test def testNotEmptyWithGenerics(): Unit ={
    val isZero = (x:Double) => x == 0
    val isNotZero1 = negGeneric1(isZero)
    val isNotZero2 = negGeneric2(isZero)

    assertTrue(isZero(0.0))
    assertFalse(isZero(8.0))
    assertTrue(isNotZero1(8.0))
    assertFalse(isNotZero1(0.0))
    assertTrue(isNotZero2(8.0))
    assertFalse(isNotZero2(0.0))
  }
}
