package coffee.models

trait Milk

abstract class FrothedMilk() extends Milk

case class FrothedWholeMilk() extends FrothedMilk {
  override def toString: String = "Frothed Whole Milk"
}

case class SemiSkimmedMilk() extends Milk

case class WholeMilk() extends Milk {

  override def toString: String = "Whole Milk"
}

