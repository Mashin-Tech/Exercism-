object Leap {
  import java.time.LocalDate
  def leapYear(year: Int): Boolean = {
    val localDate = LocalDate.parse(year.toString + "-01-01")
    localDate.isLeapYear
  }
}
