import scala.collection.mutable

/** Created the mutable Map 'roster' to store the updated states of the students
 * used the function 'toMap' to return an immutable Map to preserve the methods' signatures
 * and at the same time pass the tests which are written as if the add method had side effects */
class School {

  private type DB = Map[Int, Seq[String]]
  private val roster: mutable.Map[Int, Seq[String]] = mutable.Map[Int, Seq[String]]()

  def add(name: String, g: Int): DB = {
    if (roster.values.exists(_.contains(name))) 
      println(s"ERROR: $name is already in the school's roster.")
    else roster += g -> (roster.getOrElse(g, Seq.empty) :+ name)

    roster.toMap
  }

  def db: DB = roster.toMap

  def grade(g: Int): Seq[String] = roster.getOrElse(g, Seq.empty)

  def sorted: DB = roster.toSeq.sortBy(_._1).map{ case(g, students) => g -> students.sorted }.toMap

}

