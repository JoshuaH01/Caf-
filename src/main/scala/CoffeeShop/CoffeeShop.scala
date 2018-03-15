import scala.util.{Failure, Success, Try}

object CoffeeShop extends App {


  trait Milk

  abstract class FrothedMilk() extends Milk
  case class FrothedWholeMilk() extends FrothedMilk
  case class SemiSkimmedMilk() extends Milk
  case class WholeMilk()extends Milk

  case class Coffee(water: Water, coffeeBeans: CoffeeBeans, milk: Milk)

  // Beans
  trait CoffeeBeans {
    val brand : String
  }

  // Concrete loose beans
  case class ArabicaBeans() extends CoffeeBeans {
    override val brand: String = "Arabica"
  }


  // Ground beans
  abstract class GroundBeans() extends CoffeeBeans

  // Concrete ground beans
  case class GroundArabicaBeans() extends GroundBeans() {
    override val brand = "Arabica"
  }



  def grindBeans(coffeeBeans: Option[CoffeeBeans]) : Try[GroundBeans] = {
    coffeeBeans match {
      case Some(_ : ArabicaBeans)  => Success(GroundArabicaBeans())
      case _ => Failure(new IllegalArgumentException("No beans provided!"))
    }
  }

  def frothMilk(milk: Milk) : FrothedMilk = {
    milk match {
      case m : WholeMilk => new FrothedWholeMilk
      case _ : SemiSkimmedMilk => throw new IllegalArgumentException("Can not use Semi Skimmed Milk")
    }
  }

  case class Water(temperature : Int = 40)
    def heat(water: Water) : Water = {
      if (water.temperature >= 40) {
        water
      } else {
         Water(60)
      }
    }




    def brewCoffee(water: Water, groundBeans: GroundBeans) : Coffee = {
      (water.temperature, groundBeans) match {
        case (w,c) if w > 40 && groundBeans == GroundArabicaBeans =>
          Coffee(Water(100), ArabicaBeans(), FrothedWholeMilk())
        case (w,_) if w <= 40 =>
          throw new IllegalArgumentException("The water is to cold")
        case (_,_) =>
         throw new IllegalArgumentException ("Error, you don't know how to make coffee")
      }

//      val coffee = Coffee(Water(100), ArabicaBeans(), FrothedWholeMilk())
//      coffee
    }





}



