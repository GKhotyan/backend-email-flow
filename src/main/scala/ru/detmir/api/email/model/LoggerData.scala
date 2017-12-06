package ru.detmir.api.email.model

import ru.detmir.api.email.util.EmailGenerator.Result

case class LoggerData (notificationData: NotificationData, result: Result)
