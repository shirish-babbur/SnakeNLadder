package com.shirish.snakenladder.model

import scala.util.Random

/***
 * Crooked dice implementation
 */
class CrookedDice extends Dice {
  val numbers: List[Int] = List(2, 4, 6)
  /**
   * Rolling a dice for Crooked behaviour
   * This dice will always give even number
   * Only
   * @return Int
   */
  override def roll(): Int = {
    val randomIndex = Random.between(minInclusive = 0, maxExclusive = numbers.size - 1)
    numbers(randomIndex)
  }
}
