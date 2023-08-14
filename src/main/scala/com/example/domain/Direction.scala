package com.example.domain

sealed trait Direction extends TypedValue[Char]

object Direction {

  case object N extends Direction {
    override val value: Char = '↑'
  }

  case object S extends Direction {
    override val value: Char = '↓'
  }

  case object E extends Direction {
    override val value: Char = '→'
  }

  case object W extends Direction {
    override val value: Char = '←'
  }

}
