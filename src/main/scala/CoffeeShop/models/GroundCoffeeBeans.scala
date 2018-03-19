package CoffeeShop.models

case class GroundCoffeeBeans() extends GroundBeans {
  override val brand = "Arabica"
}

case class GroundArabicaBeans() extends GroundBeans {
  override val brand: String = "Arabica"
}

