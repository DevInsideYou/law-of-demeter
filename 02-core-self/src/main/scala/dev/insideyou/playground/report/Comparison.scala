package dev.insideyou
package playground
package report

object ComparisonImpl:
  def make(comparisonBoundary: comparison.Boundary): Comparison =
    new:
      override def doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of: String): Boolean =
        comparisonBoundary.doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of)
