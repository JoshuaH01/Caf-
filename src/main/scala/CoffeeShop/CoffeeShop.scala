import scala.util.{Failure, Success, Try}

object CoffeeShop extends App {

  trait Milk

  abstract class FrothedMilk() extends Milk

  // Beans
  abstract class CoffeeBeans {
    val brand: String
  }

  // Ground beans
  abstract class GroundBeans() extends CoffeeBeans

  case class FrothedWholeMilk() extends FrothedMilk

  case class SemiSkimmedMilk() extends Milk

  case class WholeMilk() extends Milk

  case class Water(temperature: Int = 40)

  case class Coffee(water: Water, coffeeBeans: CoffeeBeans, milk: Option[Milk] = None)

  // Concrete loose beans
  case class ArabicaBeans() extends CoffeeBeans {
    override val brand: String = "Arabica"
  }

  // Concrete ground beans
  case class GroundArabicaBeans() extends GroundBeans {
    override val brand = "Arabica"
  }

  case class GrindingBeanException(message: String) extends Exception(message)

  def grindBeans(coffeeBeans: Option[CoffeeBeans]): Try[GroundBeans] = {
    coffeeBeans match {
      case Some(_: ArabicaBeans) => Success(GroundArabicaBeans())
      case _ => Failure(GrindingBeanException("No beans provided!"))
    }
  }

  def frothMilk(milk: Milk): FrothedMilk = {
    milk match {
      case m: WholeMilk => new FrothedWholeMilk
      case _: SemiSkimmedMilk => throw new IllegalArgumentException("Can not use Semi Skimmed Milk")
    }
  }

  def heat(water: Water): Water = {
    if (water.temperature >= 40) {
      water
    } else {
      Water(60)
    }
  }

  // new method to add milk, passing in Coffee, and FrothedWholeMilk
  // method would copy the coffee, and reduce temp of water by 10 degrees
  // return coffee with milk added
  /**
  def addMilk(coffee: Coffee, milk: Milk): Coffee = {
    val w = coffee.water
    coffee.copy(w.copy(w.temperature - 10), coffee.coffeeBeans, Some(milk))
  }
    **/

  def brewCoffee(water: Water, groundBeans: GroundBeans): Coffee = {
    water.temperature match {
      case (w) if w > 40 =>
        Coffee(Water(100), groundBeans)
      case (w) if w <= 40 =>
        throw new IllegalArgumentException("The water is to cold")
      case (_) =>
        throw new IllegalArgumentException("Error, you don't know how to make coffee")
    }

    //    val coffee = Coffee(Water(100), GroundArabicaBeans(), FrothedWholeMilk())
    //    coffee
  }


  /// instantiate beans
  // instatiate milk
  // instantiate water
  // heat water
  // grind beans
  // get coffee brewed
  // if (wantMilk?) then {
  //  froth milk as well
  //  addMilk(coffee)
  //}
  // else return blackCoffee already brewed


}



