package com.shirish.snakenladder.model

/***
 * Dice trait which has ability to roll a number.
 * Can be extended this trait by implementing classes to
 * define different behaviours to roll
 */
trait Dice {

  /**
   * Rolling a dice for any behaviour
   * @return Int
   */
  def roll(): Int

}
