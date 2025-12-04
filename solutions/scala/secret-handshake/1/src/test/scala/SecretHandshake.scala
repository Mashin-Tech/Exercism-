object SecretHandshake extends App {

  val code = List("wink", "double blink", "close your eyes", "jump", "reverse")

  def commands(int: Int): List[String] = {

    // Convert to binary and reverse the order, then zip it with the code.
    val binary = int.toBinaryString.reverse
    val zipped = binary.zip(code)

    // Get a list only with codewords that have a 1 zipped.
    val zippedMapped =
      zipped.filter(_._1 == '1')
      .map{case(number, string) => string}
      .toList

    // Check for reverse and take it out of the list
    val finalCode =
      if (zippedMapped.lastOption.contains("reverse"))
        zippedMapped.filter(_ != "reverse").reverse
      else zippedMapped.filter(_ != "reverse")


    finalCode

  }
}
