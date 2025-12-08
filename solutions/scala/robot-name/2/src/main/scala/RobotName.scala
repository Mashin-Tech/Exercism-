import scala.annotation.tailrec
import scala.util.Random

object Robot {

  private var usedNames: Set[String] = Set.empty

  private def generateName(numLetters: Int = 2, numDigits: Int = 3): String = {
    val letters = Random.alphanumeric.filter(_.isLetter).take(numLetters).mkString.toUpperCase
    val digits = Random.alphanumeric.filter(_.isDigit).take(numDigits).mkString
    letters + digits
  }

  @tailrec
  private def generateUniqueName(): String = {
    val name = generateName()
    if (!usedNames.contains(name)) {
      usedNames += name
      name
    } else
      generateUniqueName()
  }

  class Robot {
    private var _name: String = generateUniqueName()

    def name: String = _name

    def reset(): Unit = {
      usedNames -= _name
      _name = generateUniqueName()
    }
  }
}