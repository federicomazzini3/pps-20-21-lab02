package u02.ex

/*
    Write a function to get the n-th Fibonacci number
    without and with tail recursion
 */
object Task3 {

  def fibonacci(n:Int):Int = n match {
    case 0 => 0
    case 1 => 1
    case n => fibonacci(n-1) + fibonacci(n-2)
  }

  //fibonacci tail recursive
  def fibonacciTail(n: Int): Int = {
    @annotation.tailrec
    def _fib(n: Int, a: Int, b: Int): Int = n match {
      case 0 => b
      case _ => _fib(n-1, a + b, a)
    }
    _fib(n, 1, 0)
  }
}
