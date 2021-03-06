package dev.insideyou
package playground
package comparison

object DependencyGraph:
  lazy val make: Controller =
    Controller.make(boundary)

  lazy val boundary: Boundary =
    Boundary.make(
      gate = Gate.make(
        google = GoogleImpl.make,
        storage = StorageImpl.make,
      )
    )
