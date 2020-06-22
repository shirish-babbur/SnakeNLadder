package com.shirish.snakenladder.model

class Ladder(val startPosition:Int, val endPosition: Int) extends Bonus(startPosition, endPosition) {
  require(startPosition < endPosition)
  require(startPosition > 1 && startPosition < 100 && endPosition > 1 && endPosition < 100)

  override def goTo(): Unit = {
  }
}
