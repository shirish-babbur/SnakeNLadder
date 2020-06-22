package com.shirish.snakenladder.utils

/***
 * Custom Exceptions are defined here
 */
object ExceptionUtils {

  /***
   * Invalid Input String exception for null or Empty string
   * @param msg: String
   */
  class InvalidInputException(msg: String) extends Exception(msg)

  /***
   * Player not found in the current game.
   * @param msg: String
   */
  class PlayerNotFoundException(msg: String) extends Exception(msg)
}
