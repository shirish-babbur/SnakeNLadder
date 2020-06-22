package com.shirish.snakenladder.model

/***
 * Ladder bonus which jump the player's position from startPosition to endPosition
 * @param startPosition: Int
 * @param endPosition: Int
 */
class Ladder(val startPosition:Int, val endPosition: Int) extends Bonus(startPosition, endPosition) {
  require(startPosition < endPosition)
  require(startPosition > 1 && startPosition < 100 && endPosition > 1 && endPosition < 100)

  /***
   * Jump and send back the end position from this ladder which will always be
   * greater than startPosition
   * @return Int
   */
  override def applyBonus(): Int = {
    this.endPosition
  }
}
