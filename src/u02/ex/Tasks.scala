package u02.ex

object Tasks {

  //es 3.a
  //function that return if a number x is even or odd
  def parityWithDef(x:Int): String = x match{
    case x if x % 2 == 0 => "even"
    case _ => "odd"
  }

  val parityWithVal:Int => String = x => x match {
    case x if x % 2 == 0 => "even"
    case _ => "odd"
  }

  //es 3.b
  //neg function that accepts a predicate on strings and returns
  //another predicate, namely, its negated form.
  val neg1:(String => Boolean) => (String => Boolean) = f => !f(_)
  val neg2: (String => Boolean) => (String => Boolean) = f => (s => !f(s))
  def neg3(f: String => Boolean): String => Boolean = (x:String) => !f(x)
  def neg4:(String => Boolean) => (String => Boolean) = f => !f(_)

  //es 3.c
  //make neg work for generic predicates
  def negGeneric1[A](f:A => Boolean): A => Boolean = (x:A) => !f(x)
  def negGeneric2[A]:(A => Boolean) => (A => Boolean) = f => !f(_)

  //es 4
  //predicate that checks whether its arguments x, y , z respect
  //the relation x ≤ y ≤ z, in 4 variants (curried/non-curried × val/def)
  //val curried
  val p1:Int=>Int=>Int=>Boolean = x => y => z => ((x <= y) && (y <= z))
  //val nonCurried
  val p2:(Int,Int,Int) => Boolean = (x,y,z) => x <= y && y <= z
  //def curried
  def p3(x:Int)(y:Int)(z:Int): Boolean = x <= y && y <= z
  //def nonCurried
  def p4(x:Int,y:Int, z:Int): Boolean = x <= y && y <= z

  //es 5
  //Function that implements functional composition
  def compose(f: Int => Int, g: Int => Int)(x:Int): Int = f(g(x))
  //generic function for compose
  def composeGenerics[A](f:A => A, g: A => A)(x: A): A = f(g(x))


  //es6
  //function to get the n-th Fibonacci number
  def fibonacci(n:Int):Int = n match {
    case 0 => 0
    case 1 => 1
    case n => fibonacci(n-1) + fibonacci(n-2)
  }

  //es 7
  sealed trait Shape
  object Shape{
    case class Rectangle(side1:Double, side2:Double) extends Shape
    case class Square(side:Double) extends Shape
    case class Circle(radius:Double) extends Shape

    def perimeter(shape: Shape): Double = shape match {
      case Rectangle(side1,side2) => side1 * 2 + side2 * 2
      case Square(side) => side * 4
      case Circle(radius) => radius * 2 * 3.14
    }

    def area(shape: Shape): Double = shape match{
      case Rectangle(side1,side2) => side1 * side2
      case Square(side) => side * side
      case Circle(radius) => radius * radius * 3.14
    }
  }

  //es 8
  sealed trait Option[A] // An Optional data type
  object Option {
    case class None[A]() extends Option[A]
    case class Some[A](a: A) extends Option[A]

    def isEmpty[A](opt: Option[A]): Boolean = opt match {
      case None() => true
      case _ => false
    }

    def getOrElse[A, B >: A](opt: Option[A], orElse: B): B = opt match {
      case Some(a) => a
      case _ => orElse
    }

    def flatMap[A,B](opt: Option[A])(f:A => Option[B]): Option[B] = opt match {
      case Some(a) => f(a)
      case _ => None()
    }

    def filter[A](opt: Option[A])(f:A => Boolean):Option[A] = opt match{
      case Some(a) if f(a) => opt
      case _ => None[A]()
    }

    def map[A](opt: Option[A])(f:A => Boolean):Option[Boolean] = opt match {
      case Some(a) if f(a) => Some(true)
      case Some(a) => Some(false)
      case _ => None()
    }

    def map2[A](opt1: Option[A], opt2: Option[A])(f:(A,A) => A):Option[A] = (opt1, opt2) match {
      case (Some(a), Some(b)) => Some(f(a,b))
      case(Some(a), None()) => Some(a)
      case(None(), Some(b)) => Some(b)
      case _ => None[A]()
    }
  }

}
