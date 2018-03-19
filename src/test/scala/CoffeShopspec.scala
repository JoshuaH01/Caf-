import CoffeeShop._
import org.scalatest.{MustMatchers, WordSpec}
import models._
import scala.util.{Failure, Success}


class CoffeeShopspec extends WordSpec with MustMatchers {

  "grindBeans" when {

    "no beans are provided" should {
      "return 'No beans provided!'" in {
        CoffeeShop.grindBeans(None) mustBe a[Failure[_]]
        CoffeeShop.grindBeans(None) mustBe Failure(GrindingBeanException("No beans provided!"))
      }
    }

    "Arabica beans given" should {
      "return'Ground Coffee'" in {
        CoffeeShop.grindBeans(Some (new ArabicaBeans)) mustEqual Success(GroundCoffeeBeans())
      }
    }
  }

  "frothMilk" when {

    "WholeMilk is given" should {
      "return'Frothed Milk'" in {
        CoffeeShop.frothMilk(WholeMilk()) mustEqual FrothedWholeMilk()
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
      "return same instance of Water" in {
        CoffeeShop.heat(Water(50)) mustEqual Water(50)
      }
    }

    "Water has boiled" should {
      "return new instance of water" in {
        CoffeeShop.heat(Water(10)) mustEqual Water(60)
      }


    }
  }

  "brewCoffee" when {

    "Water is not 40" should {
      "throw new exception" in {

        val caught = intercept[IllegalArgumentException] {
          CoffeeShop.brewCoffee(Water(30),GroundCoffeeBeans())
        }
        assert(caught.getMessage == "The water is to cold")

      }
    }

    "Water is 40 and Arabica beans are added" should {
      "return 'CoffeeWithoutMilk " in {
        CoffeeShop.brewCoffee(Water(50),GroundCoffeeBeans()) mustEqual CoffeeWithOutMilk(Water(50),GroundCoffeeBeans())
      }
    }
  }
}