package com.shirish.snakenladder.model

class Snake (val headPosition: Int, val tailPosition: Int) extends Bonus(headPosition, tailPosition) {
  require(headPosition > tailPosition)
  require(headPosition > 1 && headPosition < 100 && tailPosition > 0 && tailPosition < 100)

  override def goTo(): Unit = {
  }
}