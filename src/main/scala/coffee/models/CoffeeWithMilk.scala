package coffee.models

import coffee.controllers.{Coffee, Water}


case class CoffeeWithMilk(override val water: Water,
                          override val groundBeans: GroundBeans,
                          milk: Milk) extends Coffee(water, groundBeans) {

  override def toString: String = s"Coffee at ${water.temperature} degrees with $milk"

}
