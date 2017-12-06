package ru.detmir.api.email.actor

import akka.actor.Actor

//sends email
class EmailSender extends Actor{
  import EmailSender._

  override def receive = {
    case Send(emailAddress, emailBody) =>
      val statusPublisher = context.actorOf(StatusPublisher.props)
      val sended = sendEmail(emailAddress, emailBody)

      if (sended) statusPublisher ! StatusPublisher.UpdateStatus

  }

  def sendEmail(emailAddress: String, emailBody: String): Boolean ={
    //TODO
    println("Email sended")
    true
  }
}

object EmailSender {
  case class Send(emailAddress: String, emailBody: String)
}