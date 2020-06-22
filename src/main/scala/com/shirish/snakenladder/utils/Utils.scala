package com.shirish.snakenladder.utils

import com.shirish.snakenladder.model.Bonus

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
