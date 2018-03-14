import org.scalatest.{MustMatchers, WordSpec}

class CoffeeShopspec extends WordSpec with MustMatchers{

  "Grind beans" when {

    "nothing is given" should {
      "return 'No beans provided!'" in {
        CoffeeShop.grindBeans("") mustEqual "No beans provided!"
      }
    }

    "Arabica beans given" should {
      "return'Ground Coffee'" in {
        CoffeeShop.grindBeans("Arabica Beans") mustEqual  "Ground Coffee"
      }
    }




  }

}


