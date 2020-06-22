package com.shirish.snakenladder.utils

import com.shirish.snakenladder.UnitSpec

class UtilsSpec extends UnitSpec {

  "A utility function " should "return true if null is passed" in {
    assertResult(true)(Utils.isNullOrEmpty(null))
  }

  it should "return true if empty string is passed" in {
    assertResult(true)(Utils.isNullOrEmpty(""))
  }

  it should "return false if any non empty string is passed" in {
    assertResult(false)(Utils.isNullOrEmpty("Snake"))
  }

}
