package dev.insideyou
package playground
package comparison

private object GoogleImpl:
  lazy val make: Google =
    new:
      override def countGooglePictures(of: String): Int = 50
