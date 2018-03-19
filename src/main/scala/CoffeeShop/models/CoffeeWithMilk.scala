package CoffeeShop.models

import CoffeeShop.CoffeeShop.{Coffee, GroundBeans, Milk, Water}


case class CoffeeWithMilk(override val water: Water,
                          override val groundBeans: GroundBeans,
                          milk: Milk) extends Coffee(water, groundBeans)
