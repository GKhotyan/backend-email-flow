package ru.detmir.api.email.util

import ru.detmir.api.email.model.NotificationData

trait DataConsumer {
  def retrieveNotificationData(): Seq[NotificationData]
}
