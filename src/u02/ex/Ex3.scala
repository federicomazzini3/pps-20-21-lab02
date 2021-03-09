package u02.ex

object Ex3 {

  /*
  es 3.a
  function that return if a number x is even or odd
   */

  def parityWithDef(x:Int): String = x match{
    case x if x % 2 == 0 => "even"
    case _ => "odd"
  }

  val parityWithVal:Int => String = x => x match {
    case x if x % 2 == 0 => "even"
    case _ => "odd"
  }

  /*
  es 3.b
  neg function that accepts a predicate on strings and returns
  another predicate, namely, its negated form.
   */

  val neg1:(String => Boolean) => (String => Boolean) = f => !f(_)
  val neg2: (String => Boolean) => (String => Boolean) = f => (s => !f(s))
  def neg3(f: String => Boolean): String => Boolean = (x:String) => !f(x)
  def neg4:(String => Boolean) => (String => Boolean) = f => !f(_)

  /*
  es 3.c
  make neg work for generic predicates
   */

  def negGeneric1[A](f:A => Boolean): A => Boolean = (x:A) => !f(x)
  def negGeneric2[A]:(A => Boolean) => (A => Boolean) = f => !f(_)
}
