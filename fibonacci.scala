import scala.annotation.tailrec
object Fibonacci {
  def main(args: Array[String]) {
    // Вычисление через рекурсию
    def fibonacci_recursive(n: Int): Long = {
     if (n < 3) 1
     else fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2)
    }
    // Вычисление через цикл
    def fibonacci_loop(n: Int): Long = {
      if (n < 3) println('1')
      var first: Long = 1
      var second: Long = 1
      var fib: Long = first + second
      for(counter <- 4 to n) {
        first = second
        second = fib
        fib = first + second
      }
      fib.toLong
    }
    // Вычисление через хвостовую рекурсию. Проверка tailrec
    @tailrec
    def tail_recursion_fibonacci(n: Int, first: Long = 1, second: Long = 1) : Long = {
      if (n > 1) tail_recursion_fibonacci(n - 1, second, first + second)
      else first
    }
    //Каждый метод проверим на 10 итерациях по времени, для обычной рекурсии хватит и одной итерации))
    val t1 = System.nanoTime()
    fibonacci_recursive(45)
    val time: Double = (System.nanoTime() - t1) / 1000000000.0
    println(time)
    val t2 = System.nanoTime()
    for( i <- 0 to 10000000) {fibonacci_loop(1000)}
    val time2: Double = (System.nanoTime() - t2) / 1000000000.0
    println(time2)
    val t3 = System.nanoTime()
    for( i <- 0 to 10000000) {tail_recursion_fibonacci(1000)}
    val time3: Double = (System.nanoTime() - t3) / 1000000000.0
    println(time3)
    // Проверим корректность вычислений. Должно получиться 987.
    println(fibonacci_recursive(16))
    println(fibonacci_loop(16))
    println(tail_recursion_fibonacci(16))
  }
}
// Вывод: хвостовая рекурсия работает быстрее всех, самая медленная обычная рекурсия


