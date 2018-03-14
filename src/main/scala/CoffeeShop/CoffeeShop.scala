
object CoffeeShop extends App {


  def grindBeans(beans: String)  = {

    if (beans == "Arabica Beans") {
      "Ground Coffee"
    } else {
      "No beans provided!"
    }
  }
}