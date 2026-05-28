import scala.annotation.tailrec

object PrimeFactors {

  def factors(n: Long): List[Int] = {
    val prime = 2
    val acc = List.empty[Int]

    @tailrec
    def factorsHelper(n: Long, prime: Int, acc: List[Int]): List[Int] = {
      if (n <= 1) acc
      else {
        val isDivisible = n % prime == 0
        val restNumber = if (isDivisible) n / prime else n
        val nextPrime = if (isDivisible) prime else prime + 1
        val primeList = if (isDivisible) acc :+ prime else acc

        factorsHelper(restNumber, nextPrime, primeList)
      }
    }

    factorsHelper(n, prime, acc)
  }
}
