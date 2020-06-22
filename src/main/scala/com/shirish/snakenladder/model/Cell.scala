package com.shirish.snakenladder.model

class Cell(private val indexNumber: Int, val bonus: Option[Bonus]) {
  require(0 < indexNumber && indexNumber <= 100)

  def getIndex: Int = {
    if(this.bonus.isDefined) {
      this.bonus.get.applyBonus()
    } else {
      this.indexNumber
    }
  }
}
