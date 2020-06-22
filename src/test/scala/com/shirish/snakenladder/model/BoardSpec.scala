package com.shirish.snakenladder.model

import com.shirish.snakenladder.UnitSpec
import com.shirish.snakenladder.utils.ExceptionUtils.{InvalidBonusException, InvalidInputException}

class BoardSpec extends UnitSpec {

  private val board: Board = new Board

  override def beforeEach() = {
    this.board.initialize()
  }

  override def afterEach() = {
    this.board.clear()
  }

  "A Board " should "instance should be created" in {
    assert(board.isInstanceOf[Board])
  }

  it should "be able to initialize with 100 cells" in {
    assertResult(100)(board.getBoardSize)
  }

  it should "be able to initialize single player Raj" in {
    val playerName = "Raj"
    val isAdded = board.initPlayerState(playerName)
    assertResult(true)(isAdded)
    assertResult(true)(board.isPlayerPresent(playerName))
  }

  it should "be able to don't initialize player position if initialized twice" in {
    val playerName = "Raj"
    val isAddedFistTime = board.initPlayerState(playerName)
    val isAddedSecondTime = board.initPlayerState(playerName)
    assertResult(true)(isAddedFistTime)
    assertResult(false)(isAddedSecondTime)
  }

  it should "be able to jump to 5th Position when goToCell used with rolledNumber as 5 from 1st position" in {
    val playerName = "Raj"
    val rolledNumber = 5
    val isAddedFistTime = board.initPlayerState(playerName)
    assertResult(true)(isAddedFistTime)
    val newPosition = board.goToCell(playerName, rolledNumber)
    assertResult(5)(newPosition)
  }
  it should " raise Exception if more than 6 or less than 1 is rolled as number." in {
    val lessRolled = 0
    val largeRolled = 7
    val playerName = "Raj"
    val isAdded = board.initPlayerState(playerName)
    assertResult(true)(isAdded)
    assertThrows[InvalidInputException] {
      board.goToCell(playerName, lessRolled)
    }
    assertThrows[InvalidInputException] {
      board.goToCell(playerName, largeRolled)
    }
  }

  it should "should not change position from 99th cell if more than 1 number found after rolling." in {
    val playerName = "Raj"
    val rolledNumber = 5
    val finalCell = 99
    val isAddedFistTime = board.initPlayerState(playerName)
    assertResult(true)(isAddedFistTime)
    for(i <- 1 to 16) board.goToCell(playerName, 6)
    board.goToCell(playerName, 3)
    assertResult(finalCell)(board.getPlayerPosition(playerName))

    val updatedPosition = board.goToCell(playerName, rolledNumber)
    assertResult(finalCell)(updatedPosition)
  }

  it should "a ladder with head 4 and tail 20 should be added successfully" in {
    val playerName = "Raj"
    val isAddedFistTime = board.initPlayerState(playerName)
    assertResult(true)(isAddedFistTime)
    board.addLadder(new Ladder(4, 20))
    board.goToCell(playerName, 4)
    assertResult(20)(board.getPlayerPosition(playerName))
  }

  it should "a snake with head 5 and tail 3 should be added successfully" in {
    val playerName = "Raj"
    val isAddedFistTime = board.initPlayerState(playerName)
    assertResult(true)(isAddedFistTime)
    board.addSnake(new Snake(5, 3))
    board.goToCell(playerName, 5)
    assertResult(3)(board.getPlayerPosition(playerName))
  }

  it should "a ladder cannot be added at snake's tail" in {
    val playerName = "Raj"
    val isAddedFistTime = board.initPlayerState(playerName)
    assertResult(true)(isAddedFistTime)
    board.addSnake(new Snake(5, 3))
    assertThrows[InvalidBonusException]{
      board.addLadder(new Ladder(3, 10))
    }
  }

  it should "a snake cannot be added at ladder's tail" in {
    val playerName = "Raj"
    val isAddedFistTime = board.initPlayerState(playerName)
    assertResult(true)(isAddedFistTime)
    board.addLadder(new Ladder(3, 5))
    assertThrows[InvalidBonusException]{
      board.addSnake(new Snake(7, 5))
    }
  }

}
