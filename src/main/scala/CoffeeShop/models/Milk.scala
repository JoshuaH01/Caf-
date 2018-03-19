package CoffeeShop.models

trait Milk

abstract class FrothedMilk() extends Milk

case class FrothedWholeMilk() extends FrothedMilk

case class SemiSkimmedMilk() extends Milk

case class WholeMilk() extends Milk

