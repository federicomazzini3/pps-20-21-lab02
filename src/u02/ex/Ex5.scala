package u02.ex

/*
Write a function that implements functional composition
and a generic function of it
 */

object Ex5 {

  //function for composition
  def compose(f: Int => Int, g: Int => Int)(x:Int): Int = f(g(x))

  //generic function for composition
  def composeGenerics[A](f:A => A, g: A => A)(x: A): A = f(g(x))
}
