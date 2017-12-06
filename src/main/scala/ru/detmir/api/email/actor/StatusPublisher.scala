package ru.detmir.api.email.actor

import akka.actor.{Actor, Props}
import ru.detmir.api.email.actor.StatusPublisher.UpdateStatus

//refresh status in Kafka if email sended
class StatusPublisher extends Actor{

  override def receive = {
    case UpdateStatus =>
      println("Status updated")
  }
}

object StatusPublisher {
  def props = Props[StatusPublisher]
  case object UpdateStatus
}
