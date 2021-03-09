package u02.ex

import scala.math.Pi

object Task4 {
  sealed trait Shape
  object Shape{
    case class Rectangle(side1:Double, side2:Double) extends Shape
    case class Square(side:Double) extends Shape
    case class Circle(radius:Double) extends Shape

    def perimeter(shape: Shape): Double = shape match {
      case Rectangle(side1,side2) => side1 * 2 + side2 * 2
      case Square(side) => side * 4
      case Circle(radius) => radius * 2 * Pi
    }

    def area(shape: Shape): Double = shape match{
      case Rectangle(side1,side2) => side1 * side2
      case Square(side) => side * side
      case Circle(radius) => radius * radius * Pi
    }
  }
}
