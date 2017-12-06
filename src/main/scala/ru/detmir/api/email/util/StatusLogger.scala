package ru.detmir.api.email.util

import ru.detmir.api.email.model.{LoggerData, NotificationData}
import ru.detmir.api.email.util.EmailGenerator.Result

object StatusLogger {
  def write(tuple: Tuple2[NotificationData, Result]): Unit = {
    val email = tuple._1.email
    val description = tuple._2.description
    println(s"Email: $email Result: $description")
  }

}
