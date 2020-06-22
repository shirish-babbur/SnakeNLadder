package com.shirish.snakenladder.model

import com.shirish.snakenladder.UnitSpec

class CellSpec extends UnitSpec {

  "A Cell" should " able to Create" in {
    val cell = new Cell(1, None)
    assert(cell.isInstanceOf[Cell])
  }

  it should " throw exception if cell index is less than 0" in {
    assertThrows[IllegalArgumentException] {
      new Cell(-1, None)
    }
  }

  it should " index number for cell should be correct" in {
    val cell = new Cell(10, None)
    assertResult(10)(cell.getIndex)
  }

  it should " throw exception if cell index is less than 100" in {
    assertThrows[IllegalArgumentException] {
      new Cell(101, None)
    }
  }

  it should " able to create with bonus as snake" in {
    val cell = new Cell(10, Some(new Snake(20, 10)))
    assert(cell.bonus.isDefined)
    assert(cell.bonus.get.isInstanceOf[Snake])
  }

  it should " able to create with bonus as ladder" in {
    val cell = new Cell(10, Some(new Ladder(20, 30)))
    assert(cell.bonus.isDefined)
    assert(cell.bonus.get.isInstanceOf[Ladder])
  }

  it should " able to create with bonus as ladder and applying should give correct position" in {
    val cell = new Cell(10, Some(new Ladder(20, 30)))
    assertResult(30)(cell.getIndex)
  }

  it should " able to create with bonus as snake and applying should give correct position" in {
    val cell = new Cell(10, Some(new Snake(30, 10)))
    assertResult(10)(cell.getIndex)
  }

}
