package com.shirish.snakenladder

import com.shirish.snakenladder.service.SnakeNLadderService

object Main extends App {

  private val snakeNLadderService = new SnakeNLadderService()

  def runDriver() {
    snakeNLadderService.initialize()
    snakeNLadderService.startGame()
  }

  runDriver()
}
