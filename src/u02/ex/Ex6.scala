package u02.ex

/*
    Write a function to get the n-th Fibonacci number
 */
object Ex6 {

  def fibonacci(n:Int):Int = n match {
    case 0 => 0
    case 1 => 1
    case n => fibonacci(n-1) + fibonacci(n-2)
  }
}
