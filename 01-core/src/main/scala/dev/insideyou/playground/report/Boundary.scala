package dev.insideyou
package playground
package report

private trait Boundary:
  def sameThingForAllInputs: Option[List[Boolean]]

private object Boundary:
  def make(gate: Gate): Boundary =
    new:
      override def sameThingForAllInputs: Option[List[Boolean]] =
        Option.when(gate.isFeatureEnabled) {
          List("cats", "dogs", "hamsters")
            .map(gate.doesGoogleHaveMorePicturesThanTheLastTimeWeChecked)
        }
