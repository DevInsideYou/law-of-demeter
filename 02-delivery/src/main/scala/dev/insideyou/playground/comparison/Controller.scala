package dev.insideyou
package playground
package comparison

trait Controller:
  def run(): Unit

object Controller:
  def make(boundary: Boundary): Controller =
    new:
      override def run(): Unit =
        println(boundary.doesGoogleHaveMorePicturesThanTheLastTimeWeChecked("cats"))
