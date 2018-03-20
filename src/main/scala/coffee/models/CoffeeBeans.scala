package coffee.models

abstract class CoffeeBeans {
  val brand: String
}

abstract class GroundBeans() extends CoffeeBeans

case class ArabicaBeans() extends CoffeeBeans {
  override val brand: String = "Arabica"
}

