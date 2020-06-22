package com.shirish.snakenladder.service

import com.shirish.snakenladder.model.{Board, CrookedDice, Dice, Ladder, NormalDice, Snake}
import com.shirish.snakenladder.utils.Constants._
import com.shirish.snakenladder.utils.ExceptionUtils.InvalidBonusException

/***
 * SnakeNLadder Service which initializes board and dice
 * and lets you play the game
 */
class SnakeNLadderService {
  private val board = new Board()
  private var dice: Dice = _

  /**
   * Initializes board for playing
   */
  def initialize(): Unit = {
    board.initialize()
    addPlayer(DEFAULT_PLAYER_NAME)
  }

  def setDice(isNormal: Boolean): Unit = {
    if(isNormal) dice = new NormalDice else dice = new CrookedDice
  }

  /**
   * Default player addition is done here
   * @param playerName: String
   */
  private def addPlayer(playerName: String): Unit = {
    board.initPlayerState(playerName)
  }

  /***
   * Actual Choice based game starts here.
   * @return Boolean
   */
  def startGame(): Boolean = {
    println("Welcome to SnakeNLadder Game!")
    var exit = false
    var startGame = false
    while(!exit) {
      printInitialUsage()
      try {
        val choice = scala.io.StdIn.readInt()
        choice match {
          case 1 => buildSnake()
          case 2 => buildLadder()
          case 3 =>
            println("Starting Game...")
            exit = true
            startGame = true
          case 4 =>
            println("Thank You for Playing SnakeNLadder. Exiting")
            exit = true
          case _ => println("Invalid choice")
        }
      } catch {
        case x: InvalidBonusException => println(x.getMessage)
        case _: Throwable => println("Please Enter Number only.")
      }
    }
    if (startGame) choiceGame() else startGame
  }

  def choiceGame(): Boolean = {
    selectDice()
    var exit = false
    while(!exit) {
      printChoiceUsage()
      try {
        val choice = scala.io.StdIn.readInt()
        choice match {
          case 1 => exit = rollAndForward(dice)
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

  /**
   * Dice selection function
   */
  def selectDice(): Unit = {
    var exit = false
    while(!exit) {
      printDiceUsage()
      try {
        val choice = scala.io.StdIn.readInt()
        choice match {
          case 1 =>
            setDice(isNormal = true)
            exit = true
          case 2 =>
            setDice(isNormal = false)
            exit = true
          case _ => println("Invalid choice")
        }
      } catch {
        case x: Throwable => println("Please Enter Number only.")
      }
    }
  }

  /**
   * Common function to do the rolling and move player position.
   * @param dice: Dice
   * @return Boolean
   */
  def rollAndForward(dice: Dice): Boolean = {
    println("Rolling a Dice...")
    val rolledNumber = dice.roll()
    println(s"Rolled Number - $rolledNumber")
    board.goToCell(DEFAULT_PLAYER_NAME, rolledNumber)
    val currentPosition = board.getPlayerPosition(DEFAULT_PLAYER_NAME)
    if(currentPosition == DEFAULT_WIN_POSITION) {
      println("Congratulations! You have Won the Game.")
      true
    } else {
      println(s"Moved your position to ${board.getPlayerPosition(DEFAULT_PLAYER_NAME)}")
      false
    }
  }

  /***
   * Take input form  user to add snake
   * @return Boolean
   */
  def buildSnake(): Boolean = {
    println("Enter head position:")
    val head = scala.io.StdIn.readInt()
    println("Enter tail position:")
    val tail = scala.io.StdIn.readInt()
    board.addSnake(new Snake(head, tail))
  }

  /**
   * Take input from user to add ladder
   * @return Boolean
   */
  def buildLadder(): Boolean = {
    println("Enter head position:")
    val head = scala.io.StdIn.readInt()
    println("Enter tail position:")
    val tail = scala.io.StdIn.readInt()
    board.addLadder(new Ladder(head, tail))
  }

  /***
   * Config Menu to add snake and ladders
   */
  def printInitialUsage(): Unit = {
    println(
      """
        |Please Select Option:
        |1. Add Snake
        |2. Add Ladder
        |3. Start Game
        |4. Exit
        |""".stripMargin)
  }

  /**
   * Dice Selection Message
   */
  def printDiceUsage(): Unit = {
    println(
      """
        |Select Dice Type:
        |1. Normal Dice
        |2. Crooked Dice
        |""".stripMargin)
  }

  /**
   * Service Usage information is printed here
   */
  def printChoiceUsage(): Unit = {
    println(
      """
        |You Have Following Choices to Choose From:
        |1. Roll a Dice
        |2. Get Your Current Position
        |3. Exit Game
        |Enter a choice Number:
        |""".stripMargin)
  }
}
