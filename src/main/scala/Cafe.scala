
import coffee.controllers.{BrewingException, CafeMachine, Coffee, Water}
import coffee.models._

import scala.util.{Failure, Success, Try}

object Cafe extends App {


  val beans = ArabicaBeans()
  val milk = WholeMilk()
  val heatedWater = CafeMachine.heat(Water(20))
  val groundBeans = CafeMachine.grindBeans(Some(beans))
  val frothedMilk = Try(CafeMachine.frothMilk(milk))

  def brewCoffee() : Try[Coffee] = {
    println("brewing coffee")
    Try {
      (groundBeans, frothedMilk) match {
        case (Success(b), Success(m)) =>
          println("i have beans and milk")
          // I have beans and whole milk
          val brewed = CafeMachine.brewCoffee(heatedWater, b)
          CafeMachine.addMilk(brewed, m)
        case (Success(b), Failure(_)) =>
          println("I have beans and no milk")
          // I have beans and spoiled frothed milk
          CafeMachine.brewCoffee(heatedWater, b)
        case (Failure(be), Success(_)) =>
          println("I have no beans and milk")
          throw BrewingException(s"${be.getMessage}")
        case (Failure(be), Failure(fe)) =>
        // could not grind beanss and milk
          println("couldn't brew anything")
        throw BrewingException(s"${be.getMessage} ${fe.getMessage}")
      }
    }
  }

  brewCoffee().map(
    c =>
      println(s"You have brewed $c")
  ) recover {
    case BrewingException(m) =>
      println(s"Could not brew a coffee because '$m'")
  }

}



