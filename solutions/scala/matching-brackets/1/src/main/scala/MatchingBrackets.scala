import scala.language.postfixOps
// function iterates the string and everytime finds ( { or [, saves something to expect a ) ] or }
// If we respect the order and have only one type to close, we respect nesting also?

// (openParenth, openBracket, openCurlyBracket, lastOpen)


object MatchingBrackets {
  def isPaired(brackets: String): Boolean = {
    var openSigns: List[String] = Nil

    for (ch <- brackets) {
      ch match {
        case '(' => openSigns = "parenth" :: openSigns
        case '[' => openSigns = "bracket" :: openSigns
        case '{' => openSigns = "brace" :: openSigns

        case ')' =>
          if (openSigns.isEmpty || openSigns.head != "parenth") return false
          else openSigns = openSigns.tail

        case ']' =>
          if (openSigns.isEmpty || openSigns.head != "bracket") return false
          else openSigns = openSigns.tail

        case '}' =>
          if (openSigns.isEmpty || openSigns.head != "brace") return false
          else openSigns = openSigns.tail

        case _ => // ignore other chars
      }
    }

    openSigns.isEmpty
  }
}