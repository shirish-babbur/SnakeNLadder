package com.shirish.snakenladder.model

import com.shirish.snakenladder.utils.ExceptionUtils.PlayerNotFoundException
import com.shirish.snakenladder.utils.Validator
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

  /***
   * Initialize board with cells and empty Bonuses
   */
  def initialize(): Unit = {
    for (number <- 1 to 100) {
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
    if(!playerStates.keySet.contains(playerName)) {
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

  def addSnake(snake: Snake): Boolean = {
    false
  }

  def addLadder(ladder: Ladder): Boolean = {
    false
  }

}