package com.example.domain

sealed trait Direction extends TypedValue[Char]

object Direction {

  case object North extends Direction {
    override val value: Char = '↑'
  }

  case object South extends Direction {
    override val value: Char = '↓'
  }

  case object East extends Direction {
    override val value: Char = '→'
  }

  case object West extends Direction {
    override val value: Char = '←'
  }

}
