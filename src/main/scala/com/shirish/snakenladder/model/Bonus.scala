package com.shirish.snakenladder.model

/**
 * Bonus trait which can be a Snake or Ladder
 * @param head: Int
 * @param tail: Int
 */
abstract class Bonus(val head: Int, val tail: Int) {

  /**
   * After applying current bonus the new position for player is returned.
   * @return Int
   */
  def applyBonus(): Int
}
