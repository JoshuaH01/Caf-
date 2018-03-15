
object CoffeeShop extends App {


  trait Milk

  abstract class FrothedMilk() extends Milk
  case class FrothedWholeMilk() extends FrothedMilk
  case class SemiSkimmedMilk() extends Milk
  case class WholeMilk()extends Milk


  trait CoffeeBeans {
    val brand : String
  }

  case class ArabicaBeans() extends CoffeeBeans {
    override val brand: String = "ArabicaBeans"
  }


  def grindBeans(coffeeBeans: Option[CoffeeBeans]) : String = {
    coffeeBeans match {
      case Some(_ : ArabicaBeans)  => "Ground Coffee"
      case _ => "No beans provided!"
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


    def brewCoffee(water: Water, coffeeBeans: CoffeeBeans) : String = {
      (water.temperature, coffeeBeans) match {
        case (w,c) if w > 40 && c.brand == "ArabicaBeans" => "Coffee"
        case (w,_) if w <= 40 => throw new IllegalArgumentException("The water is to cold")
        case (_,_) => "Error, you don't know how to make coffee"
      }

     /* case class Coffee(water: Water, coffeeBeans: CoffeeBeans, milk: Milk)*/

    }





}



