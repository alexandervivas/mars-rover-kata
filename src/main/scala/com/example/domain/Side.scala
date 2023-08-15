package com.example.domain

trait Side

object Side {
  case object Front extends Side
  case object Back extends Side

  def switch(side: Side): Side = side match {
    case Front => Back
    case Back => Front
  }
}
