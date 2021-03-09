package u02.ex

object Task5 {
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

    //filter
    def filter[A](opt: Option[A])(f:A => Boolean):Option[A] = opt match{
      case Some(a) if f(a) => opt
      case _ => None[A]()
    }

    //map
    def map[A](opt: Option[A])(f:A => Boolean):Option[Boolean] = opt match {
      case Some(a) if f(a) => Some(true)
      case Some(a) => Some(false)
      case _ => None()
    }

    //map2
    def map2[A](opt1: Option[A], opt2: Option[A])(f:(A,A) => A):Option[A] = (opt1, opt2) match {
      case (Some(a), Some(b)) => Some(f(a,b))
      case(Some(a), None()) => Some(a)
      case(None(), Some(b)) => Some(b)
      case _ => None[A]()
    }
  }

}
