package com.shirish.snakenladder.utils

import com.shirish.snakenladder.utils.ExceptionUtils.InvalidInputException

/***
 * Validator object for helper validation functions
 */
object Validator {

  /***
   * Validates if input String is Empty or not
   * @param name: String
   */
  def validateNotEmpty(name: String): Unit = {
    if(Utils.isNullOrEmpty(name)) {
      throw new InvalidInputException("Name cannot be Empty")
    }
  }

  def isValidRolledNumber(rolledNumber: Int): Unit = {
    if(rolledNumber <= 0 || rolledNumber > 6) throw new InvalidInputException("Rolled Number should be between 1 to 6")
  }

}
