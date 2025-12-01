object Hamming {

  // Option for 2 strings not equal length

  // Zip 2 strings
  // Make uppercase?
  // iterate collection sum 1 when subelements are not the same

  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = {

    if (dnaStrandOne.length != dnaStrandTwo.length) None
    else {
      Some(
        dnaStrandOne
         .lazyZip(dnaStrandTwo)
         .count (_ != _)
      )
    }


  }
}
