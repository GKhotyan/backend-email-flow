package ru.detmir.api.email.actor

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import akka.stream.testkit.scaladsl.TestSink
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, MustMatchers}
import org.scalamock.scalatest.MockFactory
import ru.detmir.api.email.model.NotificationData
import ru.detmir.api.email.util.{DataConsumer, EmailDataConsumer}

class ActorsTest extends TestKit(ActorSystem("test-system"))
  with FlatSpecLike
  with ImplicitSender
  with BeforeAndAfterAll
  with MustMatchers
  with MockFactory {

  override def afterAll = {
    TestKit.shutdownActorSystem(system)
  }

  implicit val flowMaterializer = ActorMaterializer()

  "flow" should "send email" in {
    val mockDataConsumer = mock[DataConsumer]
    (mockDataConsumer.retrieveNotificationData _).expects().returning( List(NotificationData("id","email","status")) )

    val source = Source.fromIterator(() => mockDataConsumer.retrieveNotificationData().iterator)
    val testPrope = TestProbe()

    source.runWith(TestSink.probe[NotificationData]).request(1).expectNext()
  }

}

