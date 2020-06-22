package com.shirish.snakenladder.model

import com.shirish.snakenladder.utils.ExceptionUtils.{InvalidBonusException, PlayerNotFoundException}
import com.shirish.snakenladder.utils.{Utils, Validator}
import com.shirish.snakenladder.utils.Constants._

import scala.collection.mutable

/***
 * This is Board class for snakeNladder.
 * It holds information about current Positions for Players and also the board
 * itself with all the cells and snakes and ladders as a bonus
 */
class Board {
  private val boardMap: mutable.HashMap[Int, Cell] = mutable.HashMap[Int, Cell]()
  private val playerStates: mutable.HashMap[String, Cell] = mutable.HashMap[String, Cell]()
  private val snakes: mutable.Set[Int] = mutable.Set[Int]()
  private val ladders: mutable.Set[Int] = mutable.Set[Int]()

  /***
   * Initialize board with cells and empty Bonuses
   */
  def initialize(): Unit = {
    for (number <- 0 to 100) {
      boardMap.put(number, new Cell(number, None))
    }
  }

  /***
   * This will add Player if not present already at position 1
   * @param playerName: String
   * @return Boolean
   */
  def initPlayerState(playerName: String): Boolean = {
    Validator.validateNotEmpty(playerName)
    if(!this.isPlayerPresent(playerName)) {
      playerStates.put(playerName, boardMap(DEFAULT_START_POSITION))
      true
    } else {
      false
    }
  }

  /***
   * It will jump the player's position to current position + rolled Number
   * and returns the new Position.
   * @param playerName: String
   * @param rolledNumber: Int
   * @return Int
   */
  def goToCell(playerName: String, rolledNumber: Int): Int = {
    Validator.isValidRolledNumber(rolledNumber)
    if(playerStates.keySet.contains(playerName)) {
      val currentPosition = playerStates(playerName)
      val nextPosition = currentPosition.getIndex + rolledNumber
      if(nextPosition > DEFAULT_WIN_POSITION) {
        currentPosition.getIndex
      } else {
        var nextCell = boardMap(nextPosition)
        if(nextCell.bonus.isDefined) {
          nextCell = boardMap(nextCell.getIndex)
        }
        playerStates.update(playerName, nextCell)
        nextCell.getIndex
      }
    } else {
      throw new PlayerNotFoundException(s"Player with name ${playerName} not Found.")
    }
  }

  /***
   * Function to add snake with head and tail positions
   * returns true if added successfully otherwise throws error
   * @param snake: Bonus
   * @return Boolean
   */
  def addSnake(snake: Bonus): Boolean = {
    if(canAddBonus(snake)) {
      val updatedCell = boardMap(snake.head).copy(bonus=Some(snake))
      boardMap.update(snake.head, updatedCell)
      snakes.add(snake.head)
      snakes.add(snake.tail)
      true
    } else {
      throw new InvalidBonusException("Please choose different head and tail positions.")
    }
  }

  /**
   * Checks whether Bonus can be added with said
   * tail and head positions
   * @param bonus: Bonus
   * @return Boolean
   */
  def canAddBonus(bonus: Bonus): Boolean = {
    val isHeadFree = isCellFree(bonus.head)
    val isTailFree = isCellFree(bonus.tail)
    isHeadFree && isTailFree
  }

  def isCellFree(cellIndex: Int): Boolean = {
    !(snakes.contains(cellIndex) || ladders.contains(cellIndex))
  }

  /***
   * Function to add ladder with head and tail positions
   * returns true if added successfully otherwise throws error
   * @param ladder: Bonus
   * @return Boolean
   */
  def addLadder(ladder: Ladder): Boolean = {
    if(canAddBonus(ladder)) {
      val updatedCell = boardMap(ladder.head).copy(bonus=Some(ladder))
      boardMap.update(ladder.head, updatedCell)
      ladders.add(ladder.head)
      ladders.add(ladder.tail)
      true
    } else {
      throw new InvalidBonusException("Please choose different head and tail positions.")
    }
  }

  /***
   * Current Board size with cells
   * @return Int
   */
  def getBoardSize: Int = {
    // remove 0th cell
    this.boardMap.size - 1
  }

  /***
   * Searches for specified player in current player states
   * @param playerName: String
   * @return Boolean
   */
  def isPlayerPresent(playerName: String): Boolean = {
    if(Utils.isNullOrEmpty(playerName)){
      false
    } else {
      this.playerStates.keySet.contains(playerName)
    }
  }

  /**
   * Utility method to reset Everything
   */
  def clear(): Unit = {
    this.playerStates.clear()
    this.boardMap.clear()
    this.snakes.clear()
    this.ladders.clear()
  }

  /***
   * Utility method to get current Position of player
   * @param playerName: String
   * @return Int
   */
  def getPlayerPosition(playerName: String): Int = {
    Validator.validateNotEmpty(playerName)
    if(this.isPlayerPresent(playerName)){
      this.playerStates(playerName).getIndex
    } else {
      throw new PlayerNotFoundException(s"Player $playerName not Present.")
    }
  }
}
