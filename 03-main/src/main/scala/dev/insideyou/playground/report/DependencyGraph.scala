package dev.insideyou
package playground
package report

object DependencyGraph:
  lazy val make: Controller =
    Controller.make(boundary)

  lazy val boundary: Boundary =
    Boundary.make(
      gate = Gate.make(
        storage = StorageImpl.make,
        comparison = ComparisonImpl.make(
          comparisonBoundary = comparison.DependencyGraph.boundary
        ),
      )
    )
