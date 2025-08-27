object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] =   scoreMap.flatMap{case(points, letters) => letters.map(l => l.toLowerCase -> points).toMap}
  
}
