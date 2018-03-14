import org.scalatest.{MustMatchers, WordSpec}

class CoffeShopspec extends WordSpec with MustMatchers{

  "Grind beans" when {

    "nothing is given" should {
      "return 'No beans provided!'" in {
        CoffeShop.grindBeans mustEqual "No beans provided!"
      }
    }

    "Expresso beans given" should {
      "return'Expresso beans grinded!'" in {
        CoffeShop.grindBeans mustEqual "Expresso beans grinded!"
      }
    }
  }

}
