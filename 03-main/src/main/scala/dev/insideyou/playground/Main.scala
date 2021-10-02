package dev.insideyou
package playground

object Main extends App:
  println("─" * 50)

  comparison.DependencyGraph.make.run()
  println("─" * 50)
  report.DependencyGraph.make.run()

  println("─" * 50)
