/** Planet Orbital period in Earth  **/

object SpaceAge {
  
  val secondsToDays = 86400
  val earthRoundTrip = 365.25
  val planets = Map(
    "Mercury"	-> 0.2408467,
    "Venus"	-> 0.61519726,
    "Earth"	-> 1.0,
    "Mars"	-> 1.8808158,
    "Jupiter"	-> 11.862615,
    "Saturn"	-> 29.447498,
    "Uranus"	-> 84.016846,
    "Neptune"	-> 164.79132
    )
  
  def onEarth(age: Double): Double = age / (planets("Earth")* earthRoundTrip * secondsToDays) 

  def onVenus(age: Double): Double = age /(planets("Venus")* earthRoundTrip * secondsToDays)

  def onMercury(age: Double): Double =age / (planets("Mercury")* earthRoundTrip * secondsToDays)

  def onMars(age: Double): Double = age /(planets("Mars")* earthRoundTrip * secondsToDays)

  def onJupiter(age: Double): Double = age /(planets("Jupiter")* earthRoundTrip * secondsToDays)

  def onSaturn(age: Double): Double = age /(planets("Saturn")* earthRoundTrip * secondsToDays)

  def onUranus(age: Double): Double = age /(planets("Uranus")* earthRoundTrip * secondsToDays)

  def onNeptune(age: Double): Double = age /(planets("Neptune")* earthRoundTrip * secondsToDays)
}
