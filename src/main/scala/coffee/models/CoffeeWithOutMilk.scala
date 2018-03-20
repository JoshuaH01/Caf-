package coffee.models

import coffee.controllers.{Coffee, Water}


case class CoffeeWithOutMilk(override val water: Water,
                             override val groundBeans: GroundBeans
                            ) extends Coffee(water,groundBeans)