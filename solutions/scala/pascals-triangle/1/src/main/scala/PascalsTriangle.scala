import scala.annotation.tailrec
import scala.language.postfixOps

object PascalsTriangle {

  def rows(n: Int): List[List[Int]] = {

    if (n < 1) List()
    else generateTriangle(n, List(1), List(List(1)))
  }

  @tailrec
  def generateTriangle(numRows: Int,
                       lastRow: List[Int],
                       acc: List[List[Int]])
  : List[List[Int]] = {

    if (numRows <= 1) acc
    else {
      val next = nextRow(lastRow)
      generateTriangle(numRows - 1, next, acc :+ next)
    }
  }

  def nextRow(currentRow: List[Int]): List[Int] = {

    val rightPushed = 0 :: currentRow
    val leftPushed = currentRow :+ 0

    rightPushed.zip(leftPushed).map(_+_)
  }
}