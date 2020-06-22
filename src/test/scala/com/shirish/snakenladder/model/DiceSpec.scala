package com.shirish.snakenladder.model

import com.shirish.snakenladder.UnitSpec

class DiceSpec extends UnitSpec {

  "A Normal Dice" should " be instantiatable" in {
    val dice: Dice = new NormalDice
    assert(dice.isInstanceOf[NormalDice])
  }

  it should " normal dice should give number between 1 to 6" in {
    val dice: Dice = new NormalDice
    val rolledNumber = dice.roll()
    assert( rolledNumber > 0 && rolledNumber < 7)
  }

}
