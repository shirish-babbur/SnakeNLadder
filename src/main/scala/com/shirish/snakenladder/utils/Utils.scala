package com.shirish.snakenladder.utils

/***
 * utility object for helper functions
 */
object Utils {

  /**
   * Checks whether string is null or empty
   * @param input: String
   * @return
   */
  def isNullOrEmpty(input: String): Boolean = {
    input == null || input.isEmpty
  }

}
