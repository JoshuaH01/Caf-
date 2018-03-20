import coffee.controllers.{CafeMachine, GrindingBeanException, Water}
import coffee.models._
import org.scalatest.{MustMatchers, WordSpec}

import scala.util.{Failure, Success}


class CoffeeShopspec extends WordSpec with MustMatchers {

  "grindBeans" when {

    "no beans are provided" should {
      "return 'No beans provided!'" in {
        CafeMachine.grindBeans(None) mustBe a[Failure[_]]
        CafeMachine.grindBeans(None) mustBe Failure(GrindingBeanException("No beans provided!"))
      }
    }

    "Arabica beans given" should {
      "return'Ground Coffee'" in {
        CafeMachine.grindBeans(Some (new ArabicaBeans)) mustEqual Success(GroundArabicaBeans())
      }
    }
  }

  "frothMilk" when {

    "WholeMilk is given" should {
      "return'Frothed Milk'" in {
        CafeMachine.frothMilk(WholeMilk()) mustEqual FrothedWholeMilk()
      }
    }

    "SemiSkimmedMilk is given" should {
      "throw new exception" in {

        val caught = intercept[IllegalArgumentException] {
          CafeMachine.frothMilk(new SemiSkimmedMilk)
        }
        assert(caught.getMessage == "Can not use Semi Skimmed Milk")
      }
    }
  }

  "heat" when {

    "Water has not boiled" should {
      "return same instance of Water" in {
        CafeMachine.heat(Water(50)) mustEqual Water(50)
      }
    }

    "Water has boiled" should {
      "return new instance of water" in {
        CafeMachine.heat(Water(10)) mustEqual Water(60)
      }


    }
  }

  "brewCoffee" when {

    "Water is not 40" should {
      "throw new exception" in {

        val caught = intercept[IllegalArgumentException] {
          CafeMachine.brewCoffee(Water(30),GroundCoffeeBeans())
        }
        assert(caught.getMessage == "The water is to cold")

      }
    }

    "Water is 40 and Arabica beans are added" should {
      "return 'CoffeeWithoutMilk " in {
        CafeMachine.brewCoffee(Water(50),GroundCoffeeBeans()) mustEqual CoffeeWithOutMilk(Water(50),GroundCoffeeBeans())
      }
    }
  }
}