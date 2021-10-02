package dev.insideyou
package playground
package report

trait Gate extends Storage, HasOtherBoundaries
object Gate:
  def make(storage: Storage, comparisonBoundary: comparison.Boundary): Gate =
    val _comparisonBoundary = comparisonBoundary

    new:
      export storage.*

      override def comparisonBoundary = _comparisonBoundary

private trait Storage:
  def isFeatureEnabled: Boolean

private trait HasOtherBoundaries:
  def comparisonBoundary: comparison.Boundary
