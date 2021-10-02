package dev.insideyou
package playground
package report

private object Controller:
  def make(boundary: Boundary): Controller =
    new:
      override def run(): Unit =
        println(boundary.sameThingForAllInputs)
