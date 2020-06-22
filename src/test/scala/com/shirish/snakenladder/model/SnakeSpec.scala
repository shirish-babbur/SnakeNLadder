package com.shirish.snakenladder.model

import com.shirish.snakenladder.UnitSpec

class SnakeSpec extends UnitSpec {

  "A Snake" should " able to be created successfully" in {
    val snake: Bonus = new Snake(20, 10)
    assertResult(snake.head)(20)
    assertResult(snake.tail)(10)
    assert(snake.isInstanceOf[Snake])
  }

  it should " should throw exception if wanted to start at position 100" in {
    assertThrows[IllegalArgumentException] {
      new Snake(100, 10)
    }
  }

  it should " should throw exception if head position is smaller than tail position" in {
    assertThrows[IllegalArgumentException] {
      new Snake(10, 20)
    }
  }

  it should " should throw exception if head position is 1" in {
    assertThrows[IllegalArgumentException] {
      new Snake(1, 20)
    }
  }

  it should " should throw exception if head position or tail position is 0" in {
    assertThrows[IllegalArgumentException] {
      new Snake(0, 20)
    }

    assertThrows[IllegalArgumentException] {
      new Snake(10, 0)
    }
  }

  it should " able to create with bonus as snake and applying should give correct position" in {
    val snake = new Snake(30, 10)
    assertResult(10)(snake.applyBonus())
  }

}
