package dev.insideyou
package playground
package comparison

trait Gate extends Google, Storage
object Gate:
  def make(google: Google, storage: Storage): Gate =
    new:
      export google.*, storage.*

private trait Google:
  def countOurPictures(of: String): Int

private trait Storage:
  def countGooglePictures(of: String): Int
  def updatePictureCount(of: String, newCount: Int): Unit
