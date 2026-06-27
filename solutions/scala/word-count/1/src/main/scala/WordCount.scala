import WordCount.{count, countFunctional}

case class WordCount(text: String) {
  val countWords: Map[String, Int] = countFunctional(text)
}

object WordCount {

  final private val separators = Array(',' ,':', '!', '?', '\t', '\n', ' ')

  def count(text: String): Map[String, Int] = {
    val words = """'?[^a-z0-9']'?""".r.split(text.toLowerCase)
    val result = scala.collection.mutable.Map.empty[String, Int]


     for(elem <- words) {
       if (elem.nonEmpty) {
         val lowercaseElem = elem.toLowerCase()
         if (result.contains(lowercaseElem)) result(lowercaseElem) += 1
         else result.addOne(lowercaseElem, 1)
       }
     }

     result.toMap
  }
  
  def countFunctional(text: String): Map[String, Int] = {
    val words = """'?[^a-z0-9']'?""".r.split(text.toLowerCase).filter(_.nonEmpty)
    words
      .groupBy(identity)
      .view.mapValues(_.length)
      .toMap
    
  }

}
