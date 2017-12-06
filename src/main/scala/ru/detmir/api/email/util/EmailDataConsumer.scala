package ru.detmir.api.email.util

import ru.detmir.api.email.model.NotificationData

//receives data for emails from Kafka
object EmailDataConsumer extends DataConsumer {
  def retrieveNotificationData(): Seq[NotificationData] = {
    //retrive notification data from Kafka
    NotificationData
    List(NotificationData("id","email","status"))
  }
}