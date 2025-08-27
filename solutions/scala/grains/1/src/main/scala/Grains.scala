import scala.annotation.tailrec

object Grains {

  /** Gets the number of grains on square n */
  def square(n: Int): Option[BigInt] = {
     if (n < 1 || n > 64 ) None
     else Some(BigInt(2).pow(n-1))
  }
  /** Gets total number of grains on the board */
  def total: BigInt = iterateBoard(1, 0).get

  /** Iterates from square n until square 64 and accumulates the total sum  */
  @tailrec
  private def iterateBoard(n: Int, acc: BigInt): Option[BigInt] = {
    if (n > 64) Some(acc)
    else iterateBoard(n + 1, acc + square(n).get)
  }

}