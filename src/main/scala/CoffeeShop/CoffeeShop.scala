
object CoffeeShop extends App {


  trait Milk

  case class WholeMilk() extends Milk

  case class SemiSkimmedMilk() extends Milk


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

  def frothMilk(milk: Milk) : String = {
    milk match {
      case m : WholeMilk => "Frothed Milk"
      case _ : SemiSkimmedMilk => throw new IllegalArgumentException("Can not use Semi Skimmed Milk")
    }
  }

  case class Water(temperature : Int = 40)
    def heat(water: Water) : String ={
      if (water.temperature == 40) {
        "Water has not boiled"
      } else{
        "Water has boiled"
      }
    }

    def brewCoffee(water: Water, coffeeBeans: CoffeeBeans) : String = {
      (water.temperature, coffeeBeans) match {
        case (w,c) if w > 40 && c.brand == "ArabicaBeans" => "Coffee"
        case (w,_) if w <= 40 => throw new IllegalArgumentException("The water is to cold")
        case (_,_) => "Error, you don't know how to make coffee"
      }
    }
}



