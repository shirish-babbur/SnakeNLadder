package com.shirish.snakenladder.model

/***
 * Snake as bonus which can bite player's current position and downgrade them
 * from headPosition to tailPosition
 * @param headPosition: Int
 * @param tailPosition: Int
 */
class Snake (val headPosition: Int, val tailPosition: Int) extends Bonus(headPosition, tailPosition) {
  require(headPosition > tailPosition)
  require(headPosition > 1 && headPosition < 100 && tailPosition > 0 && tailPosition < 100)

  /***
   * Apply this snake bonus i.e. bite to downgrade the position and return back
   * endPosition which will be always be smaller that headPosition
   * @return Int
   */
  override def applyBonus(): Int = {
    this.tailPosition
  }
}