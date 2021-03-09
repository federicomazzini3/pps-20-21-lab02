package u02.ex

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u02.ex.Ex8.Option.{filter, map2,_}
import u02.ex.Ex8._

class Ex8Test {
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
