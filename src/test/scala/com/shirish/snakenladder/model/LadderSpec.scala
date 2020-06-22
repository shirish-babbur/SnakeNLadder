package com.shirish.snakenladder.model

import com.shirish.snakenladder.UnitSpec

class LadderSpec extends UnitSpec {

  "A Ladder" should " able to be created successfully" in {
    val snake: Bonus = new Ladder(20, 30)
    assertResult(snake.head)(20)
    assertResult(snake.tail)(30)
    assert(snake.isInstanceOf[Ladder])
  }

  it should " should throw exception if wanted to start at position 100" in {
    assertThrows[IllegalArgumentException] {
      new Ladder(100, 10)
    }
  }

  it should " should throw exception if start position is greater than end position" in {
    assertThrows[IllegalArgumentException] {
      new Ladder(20, 10)
    }
  }

  it should " should throw exception if start position is 1" in {
    assertThrows[IllegalArgumentException] {
      new Ladder(1, 20)
    }
  }

  it should " should throw exception if start position or end position is 0" in {
    assertThrows[IllegalArgumentException] {
      new Ladder(0, 20)
    }
    assertThrows[IllegalArgumentException] {
      new Ladder(10, 0)
    }
  }

  it should " able to create with bonus as ladder and applying should give correct position" in {
    val ladder = new Ladder(20, 30)
    assertResult(30)(ladder.applyBonus())
  }

}
