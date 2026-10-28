import scala.annotation.tailrec

object House {

  private final val phrases: List[String] = List(
    "This is the house that Jack built.",
    "This is the malt that lay in",
    "This is the rat that ate",
    "This is the cat that killed",
    "This is the dog that worried",
    "This is the cow with the crumpled horn that tossed",
    "This is the maiden all forlorn that milked",
    "This is the man all tattered and torn that kissed",
    "This is the priest all shaven and shorn that married",
    "This is the rooster that crowed in the morn that woke",
    "This is the farmer sowing his corn that kept",
    "This is the horse and the hound and the horn that belonged to"
  )

  private final val lineBreak: String = "\n"
  private final val doubleLineBreak: String = "\n\n"

  def recite(start: Int, end: Int): String = {
    if (start > end)
      "ERROR: Bad Input, argument 'start' can't be higher than 'end'"
    else if (start == end)
      reciteOneVerse(start) + doubleLineBreak
    else
      reciteOneVerse(start) + lineBreak + recite(start + 1, end)
  }

  private def reciteOneVerse(start: Int): String = {
    if (start == 1)
      phrases.head
    else {
      phrases(start - 1) + " " +
      reciteOneVerse(start - 1).stripPrefix("This is ")
    }
  }

}
