package dev.insideyou
package playground
package report

private trait Gate extends Storage, Comparison
private object Gate:
  def make(storage: Storage, comparison: Comparison): Gate =
    new:
      export storage.*, comparison.*

private trait Storage:
  def isFeatureEnabled: Boolean

private trait Comparison:
  def doesGoogleHaveMorePicturesThanTheLastTimeWeChecked(of: String): Boolean
