package dev.insideyou
package playground
package report

trait Gate extends Storage
object Gate:
  def make(storage: Storage): Gate =
    new:
      export storage.*

private trait Storage:
  def isFeatureEnabled: Boolean
