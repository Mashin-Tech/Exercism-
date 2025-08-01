object Bob {
  def response(statement: String): String = {
    // use () because trim has side effects
    val input = statement.trim()
    // don't use (), because isEmpty has no side effects
    if (input.isEmpty) return "Fine. Be that way!"
    val isShout =
      input.exists(_.isLetter) && input.toUpperCase() == input
    (input.endsWith("?"), isShout) match {
      case (true, true) => "Calm down, I know what I'm doing!"
      case (_, true)    => "Whoa, chill out!"
      case (true, _)    => "Sure."
      case _            => "Whatever."
    }
  }
}