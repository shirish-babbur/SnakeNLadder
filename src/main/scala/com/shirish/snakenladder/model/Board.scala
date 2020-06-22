package com.shirish.snakenladder.model

import scala.collection.mutable

class Board {
  private val boardMap: mutable.HashMap[Int, Cell] = mutable.HashMap[Int, Cell]()
  private val playerStates: mutable.HashMap[String, Cell] = mutable.HashMap[String, Cell]()

  def initialize(): Unit = {
    for (number <- 1 to 100) {
      if (number == 100) {
        boardMap.put(number, new Cell(number, Some(new Snake(99, 1))))
      } else {
        boardMap.put(number, new Cell(number, None))
      }
    }
    println("Cell 100 should have snake from 100 to 1")
    val x = boardMap(100)
    println(s"cell - ${x.getIndex} and bonus (isDefined - ${x.bonus.isDefined}, class - ${x.bonus.get.getClass})")
    println(s"Snake is head - ${x.bonus.get.head} , tail - ${x.bonus.get.tail}")
  }

  def goToCell(playerName: String, rolledNumber: Int): Int = {
    0
  }

}
