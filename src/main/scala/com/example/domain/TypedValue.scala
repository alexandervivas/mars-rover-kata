package com.example.domain

trait TypedValue[T] {

  val value: T

  override def toString: String = value.toString

}
