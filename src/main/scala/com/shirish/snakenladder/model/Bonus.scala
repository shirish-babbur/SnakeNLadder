package com.shirish.snakenladder.model

abstract class Bonus(val head: Int, val tail: Int) {

  def applyBonus(): Int
}