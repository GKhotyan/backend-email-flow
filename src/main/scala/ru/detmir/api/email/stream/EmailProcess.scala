package ru.detmir.api.email.stream

import akka.actor.{ActorSystem, Props}
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}
import ru.detmir.api.email.actor.EmailSender
import ru.detmir.api.email.actor.EmailSender.Send
import ru.detmir.api.email.model.NotificationData
import ru.detmir.api.email.util.EmailGenerator.Result
import ru.detmir.api.email.util.{EmailDataConsumer, EmailGenerator, StatusLogger}

object EmailProcess extends App{
  implicit val actorSystem = ActorSystem()
  import actorSystem.dispatcher
  implicit val flowMaterializer = ActorMaterializer()

  val emailSender = actorSystem.actorOf(Props[EmailSender], "emailSender")

  val source = Source.fromIterator(() => EmailDataConsumer.retrieveNotificationData().iterator)

  val flow = Flow[NotificationData]
    .map({data =>
      val result = EmailGenerator.getEmailGenerationResult(data)
      if(result.status) emailSender ! Send(data.email, result.description)
      (data, result)
    })

  val sink = Sink.foreach[(NotificationData, Result)](StatusLogger.write)

  source.via(flow).runWith(sink).andThen{
    case _ =>
      actorSystem.terminate()
  }

}
