import CoffeeShop._
import org.scalatest.{MustMatchers, WordSpec}

import scala.xml.Null

class CoffeeShopspec extends WordSpec with MustMatchers {

  "grindBeans" when {

    "nothing is given" should {
      "return 'No beans provided!'" in {
        CoffeeShop.grindBeans(None) mustEqual "No beans provided!"
      }
    }

    "Arabica beans given" should {
      "return'Ground Coffee'" in {
        CoffeeShop.grindBeans(Some (new ArabicaBeans)) mustEqual "Ground Coffee"
      }
    }
  }

  "frothMilk" when {

    "WholeMilk is given" should {
      "return'Frothed Milk'" in {
        CoffeeShop.frothMilk(WholeMilk()) mustEqual "Frothed Milk"
      }
    }

    "SemiSkimmedMilk is given" should {
      "throw new exception" in {

        val caught = intercept[IllegalArgumentException] {
          CoffeeShop.frothMilk(new SemiSkimmedMilk)
        }
        assert(caught.getMessage == "Can not use Semi Skimmed Milk")
      }
    }
  }

  "heat" when {

    "Water has not boiled" should {
      "return 'Water has not boiled " in {
        CoffeeShop.heat(Water()) mustEqual "Water has not boiled"
      }
    }

    "Water has boiled" should {
      "return 'Water has boiled " in {
        CoffeeShop.heat(Water(100)) mustEqual "Water has boiled"
      }


    }
  }

  "brewCoffee" when {

    "Water is not 40" should {
      "throw new exception" in {

        val caught = intercept[IllegalArgumentException] {
          CoffeeShop.brewCoffee(Water(30),new ArabicaBeans)
        }
        assert(caught.getMessage == "The water is to cold")

      }
    }

    "Water is 40 and Arabica beans are added" should {
      "return 'Coffee " in {
        CoffeeShop.brewCoffee(Water(50),new ArabicaBeans) mustEqual "Coffee"
      }


    }
  }



}