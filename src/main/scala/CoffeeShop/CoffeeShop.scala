
object CoffeeShop extends App {


  trait Milk

  case class WholeMilk() extends Milk

  case class SemiSkimmedMilk() extends Milk


  def grindBeans(beans: String) = {

    if (beans == "Arabica Beans") {
      "Ground Coffee"
    } else {
      "No beans provided!"
    }
  }

  def frothMilk(milk: Milk) : String = {
    milk match {
      case m : WholeMilk => "Frothed Milk"
      case _ : SemiSkimmedMilk => throw new IllegalArgumentException("Can not use Semi Skimmed Milk")
    }
  }

  case class Water(val temperature : Int = 40)
    def heat(water: Water) : String ={
      if (water.temperature == 40) {
        "Water has not boiled"
      } else{
        "Water has boiled"
      }
    }

}



