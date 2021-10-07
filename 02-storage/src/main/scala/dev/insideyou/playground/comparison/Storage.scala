package dev.insideyou
package playground
package comparison

private object StorageImpl:
  lazy val make: Storage =
    new:
      override def countOurPictures(of: String): Int = 1000
      override def updatePictureCount(of: String, newCount: Int): Unit = ()
