package com.shirish.snakenladder.model

class Cell(val indexNumber: Int, val bonus: Option[Bonus]) {
  require(0 <= indexNumber && indexNumber <= 100)
}
