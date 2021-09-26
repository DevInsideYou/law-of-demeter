package dev.insideyou
package playground
package comparison

import BoundarySuite.*

final class BoundarySuite extends TestSuite:
  test("test 1") {
    val boundary: Boundary =
      Boundary.make(
        gate = new FakeGate
      )

    a[NotImplementedError] `should` be thrownBy {
      boundary.doesGoogleHaveMorePicturesThanTheLastTimeWeChecked("cats")
    }
  }

  test("test 2") {
    forAll { (googleCount: Int, ourCount: Int) =>
      val boundary: Boundary =
        Boundary.make(
          gate = new FakeGate:
            override def countGooglePictures(of: String): Int = googleCount
            override def countOurPictures(of: String): Int = ourCount
            override def updatePictureCount(of: String, newCount: Int): Unit = ()
        )

      val expected = googleCount > ourCount

      boundary.doesGoogleHaveMorePicturesThanTheLastTimeWeChecked("cats") `shouldBe` expected
    }
  }

  test("test 3") {
    forAll { (googleCount: Int, ourCount: Int) =>
      var updatePictureCountWasCalled = false

      val boundary: Boundary =
        Boundary.make(
          gate = new FakeGate:
            override def countGooglePictures(of: String): Int = googleCount
            override def countOurPictures(of: String): Int = ourCount
            override def updatePictureCount(of: String, newCount: Int): Unit =
              updatePictureCountWasCalled = true
              newCount `shouldBe` googleCount
        )

      updatePictureCountWasCalled `shouldBe` false
      boundary.doesGoogleHaveMorePicturesThanTheLastTimeWeChecked("cats")
      updatePictureCountWasCalled `shouldBe` true
    }
  }

object BoundarySuite:
  class FakeGate extends Gate:
    override def countGooglePictures(of: String): Int = ???
    override def countOurPictures(of: String): Int = ???
    override def updatePictureCount(of: String, newCount: Int): Unit = ???
