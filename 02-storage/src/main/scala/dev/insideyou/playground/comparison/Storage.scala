package dev.insideyou
package playground
package comparison

private object StorageImpl:
  lazy val make: Storage =
    new:
      override def countGooglePictures(of: String): Int = 50
      override def updatePictureCount(of: String, newCount: Int): Unit = ()
