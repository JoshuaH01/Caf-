package CoffeeShop.models

import CoffeeShop.CoffeeShop.{Coffee, GroundBeans, Water}


case class CoffeeWithOutMilk(override val water: Water,
                             override val groundBeans: GroundBeans
                            ) extends Coffee(water,groundBeans)