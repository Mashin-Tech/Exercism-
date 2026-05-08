case class Triangle(a: Double, b: Double, c: Double) {

  val isTriangle: Boolean = {
    a > 0 &&
    b > 0 &&
    c > 0 &&
    a + b >= c &&
    b + c >= a &&
    a + c >= b
  }

  val equilateral: Boolean = isTriangle && a == b && b == c
  val isosceles: Boolean = isTriangle && !equilateral && a == b || b == c || a == c 
  val scalene: Boolean = isTriangle && !isosceles

}