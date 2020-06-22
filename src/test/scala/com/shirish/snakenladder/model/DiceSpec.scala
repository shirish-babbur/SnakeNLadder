package com.shirish.snakenladder.model

import com.shirish.snakenladder.UnitSpec

class DiceSpec extends UnitSpec {

  "A Normal Dice " should "be instantiatable" in {
    val dice: Dice = new NormalDice
    assert(dice.isInstanceOf[NormalDice])
  }

  it should "normal dice should give number between 1 to 6" in {
    val dice: Dice = new NormalDice
    val rolledNumber = dice.roll()
    assert( rolledNumber > 0 && rolledNumber < 7)
  }

  "A Crooked Dice " should "be instantiatable easily" in {
    val dice: Dice = new CrookedDice
    assert(dice.isInstanceOf[CrookedDice])
  }

  it should "crooked dice should always give even number between 1 to 6" in {
    val dice: Dice = new CrookedDice
    val rolledNumber = dice.roll()
    assert( rolledNumber > 0 && rolledNumber < 7)
    assert(rolledNumber %  2 == 0)
  }

}
