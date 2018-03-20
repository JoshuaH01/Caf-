package coffee.models

case class GroundCoffeeBeans() extends GroundBeans {
  override val brand = "Arabica"
}

case class GroundArabicaBeans() extends GroundBeans {
  override val brand: String = "Ground Arabica"
}

