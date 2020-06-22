package com.shirish.snakenladder.model

/***
 * Cell object which stores indexNumber and bonus instance
 * bonus can be Snake or Ladder
 * @param indexNumber: Int
 * @param bonus: Option[Bonus]
 */
case class Cell(private val indexNumber: Int, val bonus: Option[Bonus]) {
  require(0 <= indexNumber && indexNumber <= 100)

  /***
   * Get index for this cell might be snake bite or
   * ladder and if not just index number.
   * @return Int
   */
  def getIndex: Int = {
    if(this.bonus.isDefined) {
      this.bonus.get.applyBonus()
    } else {
      this.indexNumber
    }
  }
}
