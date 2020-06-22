package com.shirish.snakenladder

import com.shirish.snakenladder.model.{Board, Dice, NormalDice}

object SnakeNLadderApplication extends App{

  val board = new Board()
  val dice: Dice = new NormalDice
  board.initialize()
}
