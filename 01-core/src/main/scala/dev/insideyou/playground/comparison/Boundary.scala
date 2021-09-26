package dev.insideyou
package playground
package comparison

trait Boundary:
  def doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of: String): Boolean

object Boundary:
  def make(gate: Gate): Boundary =
    new:
      override def doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of: String): Boolean =
        val ours = gate.countOurPictures(of)
        val googles = gate.countGooglePictures(of)

        gate.updatePictureCount(of, googles)

        googles > ours
