package ru.detmir.api.email.util

import ru.detmir.api.email.model.NotificationData

//receives email frome remote service
object EmailGenerator {
  def getEmailGenerationResult(notificationData: NotificationData): Result = {
    Result(true, "emailBody")
  }

  case class Result(status: Boolean, description: String)
}


