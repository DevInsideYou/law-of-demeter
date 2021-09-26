package dev.insideyou
package playground
package comparison

object DependencyGraph:
  lazy val make: Controller =
    Controller.make(
      boundary = Boundary.make(
        gate = Gate.make(
          google = GoogleImpl.make,
          storage = StorageImpl.make,
        )
      )
    )
