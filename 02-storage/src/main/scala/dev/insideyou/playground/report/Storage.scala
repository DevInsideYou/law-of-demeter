package dev.insideyou
package playground
package report

object StorageImpl:
  lazy val make: Storage =
    new:
      override def isFeatureEnabled: Boolean =
        true
