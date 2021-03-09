package u02.ex

/*
  predicate that checks whether its arguments x, y , z respect
  the relation x ≤ y ≤ z, in 4 variants (curried/non-curried × val/def)
 */

object Ex4 {

  //val curried
  val p1:Int=>Int=>Int=>Boolean = x => y => z => ((x <= y) && (y <= z))
  //val nonCurried
  val p2:(Int,Int,Int) => Boolean = (x,y,z) => x <= y && y <= z
  //def curried
  def p3(x:Int)(y:Int)(z:Int): Boolean = x <= y && y <= z
  //def nonCurried
  def p4(x:Int,y:Int, z:Int): Boolean = x <= y && y <= z
}
