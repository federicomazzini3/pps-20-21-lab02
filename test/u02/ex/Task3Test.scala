package u02.ex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.ex.Task3._

class Task3Test {
  //es 6
  @Test def testFibonacci(): Unit ={
    assertEquals(196418, fibonacci(27))
  }

  @Test def testFibonacciTailRecursion(): Unit ={
    assertEquals(196418, fibonacciTail(27))
  }
}
