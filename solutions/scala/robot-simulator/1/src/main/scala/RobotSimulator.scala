import Bearing.{East, North, South, West}
import scala.language.postfixOps


enum Bearing { case North, West, South, East }

/** Made without case class for the purposes of practice. Implemented equals, copy, hashcode and toString not necessary
 * if we use a case class  */
class Robot(val bearing: Bearing = North, val coordinates: (Int, Int) = (0,0)) {

  override def equals(obj: Any): Boolean = {
    try { val r2d2 = obj.asInstanceOf[Robot]
          this.bearing == r2d2.bearing && this.coordinates == r2d2.coordinates
    }catch { case e: Exception => 
      println("Robot compared to a non-Robot")
      false
    }
  }

  private def copy(bearing: Bearing = this.bearing, coordinates: (Int, Int) = this.coordinates): Robot =
    new Robot(bearing, coordinates)

  override def hashCode(): Int = (bearing, coordinates).##

  override def toString: String = s"Robot($bearing, $coordinates)"


  def turnRight: Robot =
    bearing match
      case North => copy(East)
      case East => copy(South)
      case South => copy(West)
      case West => copy(North)


  def turnLeft: Robot =
    bearing match
      case North => copy(West)
      case East => copy(North)
      case South => copy(East)
      case West => copy(South)


  def advance: Robot =
      bearing match
      case North => copy(coordinates = (coordinates._1, coordinates._2 + 1))
      case South => copy(coordinates = (coordinates._1, coordinates._2 -1))
      case East => copy(coordinates = (coordinates._1 + 1, coordinates._2 ))
      case West => copy(coordinates = (coordinates._1 - 1, coordinates._2 ))


  def simulate(instructions: String): Robot = {
    var robot = this
    for (char <- instructions.toList)
      char match {
        case 'A' => robot = robot.advance
        case 'R' => robot = robot.turnRight
        case 'L' => robot = robot.turnLeft
        case _   => robot = robot
    }
    robot
  }


}