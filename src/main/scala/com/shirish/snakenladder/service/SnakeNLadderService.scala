package com.shirish.snakenladder.service

import com.shirish.snakenladder.model.{Board, Dice, NormalDice}
import com.shirish.snakenladder.utils.Constants._
import scala.collection.mutable

class SnakeNLadderService {
  private val board = new Board()
  private val dice: Dice = new NormalDice
  private val playersQueue: mutable.Queue[String] = mutable.Queue[String]()

  def initialize(): Unit = {
    board.initialize()
    addPlayer(DEFAULT_PLAYER_NAME)
  }

  private def addPlayer(playerName: String): Unit = {
    playersQueue.enqueue(playerName)
    board.initPlayerState(playerName)
  }

  def startGame(): Boolean = {
    println("Welcome to SnakeNLadder Game!")
    var exit = false
    while(!exit) {
      printUsage()
      try {
        val choice = scala.io.StdIn.readInt()
        choice match {
          case 1 =>
            println("Rolling a Dice...")
            val rolledNumber = dice.roll()
            println(s"Rolled Number - $rolledNumber")
            board.goToCell(DEFAULT_PLAYER_NAME, rolledNumber)
            val currentPosition = board.getPlayerPosition(DEFAULT_PLAYER_NAME)
            if(currentPosition == DEFAULT_WIN_POSITION) {
              println("Congratulations! You have Won the Game.")
              exit = true
            } else {
              println(s"Moved your position to ${board.getPlayerPosition(DEFAULT_PLAYER_NAME)}")
            }
          case 2 => println(s"Your Current Position - ${board.getPlayerPosition(DEFAULT_PLAYER_NAME)}")
          case 3 =>
            println("Thank You for Playing SnakeNLadder. Exiting1")
            exit = true
          case _ => println("Invalid choice")
        }
      } catch {
        case _: Throwable => println("Please Enter Number only.")
      }
    }
    exit
  }

  def printUsage() = {
    println(
      """
        |You Have Following Choices to Choose From:
        |1. Roll a Dice with Normal Dice
        |2. Get Your Current Position
        |3. Exit Game
        |Enter a choice Number:
        |""".stripMargin)
  }
}
