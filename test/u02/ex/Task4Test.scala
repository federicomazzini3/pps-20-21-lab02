package u02.ex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.ex.Task4.Shape._

import scala.math.Pi

class Task4Test {
  //es 7

  @Test def testRectangle(): Unit ={

    val side1:Int = 5
    val side2:Int = 6
    val calcPerimeter: (Double, Double) => Double = _ * 2 + _ * 2
    val calcArea: (Double, Double) => Double = _ * _

    val rectangle:Rectangle = Rectangle(side1,side2)

    assertEquals(calcPerimeter(side1,side2),perimeter(rectangle))
    assertEquals(calcArea(side1,side2),area(rectangle))
  }

  @Test def testSquare(): Unit ={
    val side:Int = 5
    val calcPerimeter:(Double) => Double = _ * 4
    val calcArea:(Double) => Double = (side:Double) => side * side

    val square:Square = Square(side)

    assertEquals(calcPerimeter(side),perimeter(square))
    assertEquals(calcArea(side),area(square))
  }

  @Test def testCircle(): Unit ={
    val radius: Int = 10
    val calcPerimeter:(Double) => Double = _ * 2 * Pi
    val calcArea:(Double) => Double = (radius:Double) => radius * radius * Pi
    val circle:Circle = Circle(radius)

    assertEquals(calcPerimeter(radius),perimeter(circle))
    assertEquals(calcArea(radius),area(circle))
  }
}
