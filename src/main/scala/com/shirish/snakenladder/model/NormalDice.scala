package com.shirish.snakenladder.model

import scala.util.Random

/***
 * Normal Dice which basically has ability to roll a dice
 */
class NormalDice extends Dice {

  /***
   * roll function gives out random number between 1 to 6
   * @return Int
   */
  override def roll(): Int = {
    Random.between(minInclusive = 1, maxExclusive = 7)
  }
}
