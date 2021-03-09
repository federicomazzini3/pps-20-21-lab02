package u02.ex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.ex.Ex7.Shape._

class Ex7Test {
  //es 7
  @Test def testShape(): Unit ={
    val rectangle:Rectangle = Rectangle(5,6)
    val square:Square = Square(5)
    val circle:Circle = Circle(10)

    assertEquals(22,perimeter(rectangle))
    assertEquals(30,area(rectangle))

    assertEquals(20,perimeter(square))
    assertEquals(25,area(square))

    assertEquals(62.8,perimeter(circle),0.000001)
    assertEquals(314,area(circle))
  }
}
