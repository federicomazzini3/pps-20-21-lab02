package u02.ex

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u02.ex.Tasks.Option._
import u02.ex.Tasks.Shape._
import u02.ex.Tasks.{fibonacci, _}

class TasksTest {

  //es3
  @Test def testParity(){
    assertEquals("even", parityWithDef(4))
    assertEquals("odd", parityWithDef(5))
  }

  @Test def testEmpty(): Unit ={
    val empty1: String => Boolean = (s:String) =>  (s == "")
    val empty2: String => Boolean = _ == ""
    val empty3 = (s:String) => s==""

    assertTrue(empty1(""))
    assertFalse(empty1("a"))
  }

  //es 3.b
  @Test def testNotEmpty(): Unit ={
    val empty: String => Boolean = (s:String) =>  (s == "")
    val notEmpty = neg3(empty)

    assertFalse(notEmpty(""))
    assertTrue(notEmpty("a"))
  }

  //es 3.c
  @Test def testNotEmptyWithGenerics(): Unit ={
    val isZero = (x:Double) => x == 0
    val isNotZero = negGeneric(isZero)

    assertTrue(isZero(0.0))
    assertFalse(isZero(8.0))
    assertTrue(isNotZero(8.0))
    assertFalse(isNotZero(0.0))
  }

  //es 4
  @Test def testCurrying(): Unit ={
    val p1:Int=>Int=>Int=>Boolean = x => y => z => ((x <= y) && (y <= z))
    val p2:(Int,Int,Int) => Boolean = (x,y,z) => x <= y && y <= z
    def p3(x:Int)(y:Int)(z:Int): Boolean = x <= y && y <= z
    def p4(x:Int,y:Int, z:Int): Boolean = x <= y && y <= z

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
    def composeGenerics[A](f:A => A, g: A => A)(x: A): A = f(g(x))
    def reverseString(s:String): String = s.reverse
    def minus1(n:Int) = n - 1
    def mult2(n:Int) = n * 2
    assertEquals("olleh", reverseString("hello"))


    assertEquals(9, composeGenerics(minus1, mult2)(5))
    assertEquals("hello", composeGenerics(reverseString, reverseString)("hello"))
  }

  //es 6
  @Test def testFibonacci(): Unit ={
    println(196418, fibonacci(27))
  }

  //es 7
  @Test def testShape(): Unit ={
    val rectangle:Rectangle = Rectangle(5,6)
    assertEquals(22,perimeter(rectangle))
    assertEquals(30,area(rectangle))
    val square:Square = Square(5)
    assertEquals(20,perimeter(square))
    assertEquals(25,area(square))
    val circle:Circle = Circle(10)
    assertEquals(62.8,perimeter(circle),0.000001)
    assertEquals(314,area(circle))
  }

  //es 8
  @Test def testOptionFilter(): Unit ={
    val s1: Option[Int] = Some(5)
    val s2: Option[Int] = Some(1)
    assertEquals(Some[Int](5), filter(s1)(_>2))
    assertEquals(None[Int], filter(s2)(_>2))
  }

  @Test def testOptionMap(): Unit ={
    val s1:Option[Int] = Some(5)
    val s2:Option[Int] = Some(0)
    val s3:Option[Int] = None()
    val greaterThan2 = (n:Int) => n > 2
    assertEquals(Some(true), map(s1)(greaterThan2))
    assertEquals(Some(false), map(s2)(greaterThan2))
    assertEquals(None(), map(s3)(greaterThan2))
  }

  @Test def testMap2(): Unit ={
    val sum = (v1:Int, v2: Int) => v1 + v2
    val and = (v1:Boolean,v2:Boolean)=> v1 && v2
    val or = (v1:Boolean, v2:Boolean) => v1 || v2

    assertEquals(Some(5), map2(Some(2),Some(3))(sum))
    assertEquals(Some(3), map2[Int](Some(3),None[Int]())(sum))
    assertEquals(Some(3), map2[Int](None[Int](),Some(3))(sum))
    assertEquals(None(), map2[Int](None(),None())(sum))

    assertEquals(Some(false), map2(Some(true),Some(false))(and))
    assertEquals(Some(true), map2(Some(true),Some(true))(and))
    assertEquals(Some(true), map2(Some(true),Some(false))(or))
    assertEquals(Some(true), map2(Some(true),None())(or))
    assertEquals(Some(false), map2(None(),Some(false))(or))
    assertEquals(None(), map2[Boolean](None(),None())(or))
    assertEquals(None(), map2[Boolean](None(),None())(or))
  }
}
