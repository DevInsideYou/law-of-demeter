package dev.insideyou
package playground
package comparison

private object GoogleImpl:
  lazy val make: Google =
    new:
      override def countOurPictures(of: String): Int = 1000
