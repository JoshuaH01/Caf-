import CoffeeShop.{SemiSkimmedMilk, Water, WholeMilk}
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

  "frothMilk" when {

    "WholeMilk is given" should {
      "return'Frothed Milk'" in {
        CoffeeShop.frothMilk(new WholeMilk()) mustEqual "Frothed Milk"
      }
    }

    "SemiSkimmedMilk is given" should {
      "throw new exception in" in {

        val caught = intercept[IllegalArgumentException] { CoffeeShop.frothMilk(new SemiSkimmedMilk)
          }
        assert(caught.getMessage == "Can not use Semi Skimmed Milk")
      }
    }
  }

 "Heat" when {
   
   "Water has not boiled" should{
     "return 'Water has not boiled " in{
       CoffeeShop.heat(Water()) mustEqual "Water has not boiled"
     }
   }
 }


}


