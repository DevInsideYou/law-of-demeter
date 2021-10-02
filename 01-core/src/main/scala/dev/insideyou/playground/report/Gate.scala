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
