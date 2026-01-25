class DNA (val sequence: String) {

  def nucleotideCounts: Either[String, scala.collection.mutable.Map[Char, Int]] = {

    val count: scala.collection.mutable.Map[Char, Int] =
      scala.collection.mutable.Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)

    for (char <- sequence) {
      char match
        case 'A' => count('A') += 1
        case 'C' => count('C') += 1
        case 'G' => count('G') += 1
        case 'T' => count('T') += 1
        case _ => return Left("Wrong char in sequence")
    }

    Right(count)
  }

}
