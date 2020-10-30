package services

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

class User(private val name: String, private val login: String, private val mail: String) {
  private val DATE_FORMAT = "EEE, MMM dd, yyyy h:mm a"
  private val registrationTime = getDateAsString(Calendar.getInstance.getTime)

  def getDateAsString(d: Date): String = {
    val dateFormat = new SimpleDateFormat(DATE_FORMAT)
    dateFormat.format(d)
  }

  def getName: String = name

  def getLogin: String = login

  def getMail: String = mail

  def getRegistrationTime: String = registrationTime

  override def toString: String =
    s"User: ($name, $login, $mail, $getRegistrationTime)"
}
