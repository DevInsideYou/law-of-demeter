package dev.insideyou
package playground
package report

trait Gate extends Storage, Comparison
object Gate:
  def make(storage: Storage, comparison: Comparison): Gate =
    new:
      export storage.*, comparison.*

private trait Storage:
  def isFeatureEnabled: Boolean

private trait Comparison:
  def doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of: String): Boolean

object ComparisonImpl:
  def make(comparisonBoundary: comparison.Boundary): Comparison =
    new:
      override def doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of: String): Boolean =
        comparisonBoundary.doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of)
