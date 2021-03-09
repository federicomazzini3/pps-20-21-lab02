package u02.ex

object Task2b {
  /*
    predicate that checks whether its arguments x, y , z respect
    the relation x ≤ y ≤ z, in 4 variants (curried/non-curried × val/def)
   */

  //val curried
  val p1:Int=>Int=>Int=>Boolean = x => y => z => ((x <= y) && (y <= z))
  //val nonCurried
  val p2:(Int,Int,Int) => Boolean = (x,y,z) => x <= y && y <= z
  //def curried
  def p3(x:Int)(y:Int)(z:Int): Boolean = x <= y && y <= z
  //def nonCurried
  def p4(x:Int,y:Int, z:Int): Boolean = x <= y && y <= z

  /*
  Write a function that implements functional composition
  and a generic function of it
   */

  //function for composition
  def compose(f: Int => Int, g: Int => Int)(x:Int): Int = f(g(x))

  //generic function for composition
  def composeGenerics[A](f:A => A, g: A => A)(x: A): A = f(g(x))
}
