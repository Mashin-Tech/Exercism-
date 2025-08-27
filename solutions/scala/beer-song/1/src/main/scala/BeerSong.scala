object BeerSong {
  import scala.annotation.tailrec
  
  def recite(bottles: Int, times: Int): String = {
    def phrase(bottles: Int): String =  bottles match {
        case 0 => ("No more bottles of beer on the wall, "
            + "no more bottles of beer.\n"
            + "Go to the store and buy some more, "
            + "99 bottles of beer on the wall.\n")
        case 1 => ("1 bottle of beer on the wall, "
            + "1 bottle of beer.\n"
            + "Take it down and pass it around, "
            + "no more bottles of beer on the wall.\n")
        case n => (s"$n bottles of beer on the wall, "
            + s"$bottles bottles of beer.\n"
            + "Take one down and pass it around, "
            + s"${bottles-1} ${if (bottles > 2) "bottles" else "bottle"} "
            + "of beer on the wall.\n")
      
    }
    @tailrec
    def reciteAux(bottles: Int, times: Int, acc: StringBuilder): String = {
      if (times == 0) acc.toString
      else reciteAux(bottles-1, times-1, acc ++= "\n" ++=  phrase(bottles))
    }
    reciteAux(bottles-1, times-1, new StringBuilder(phrase(bottles)))
  }
}
