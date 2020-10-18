package services

case class User (var name: String, var login: String, var mail: String, var registrationTime: Int) {
  override def toString: String =
    s"User: ($name, $login, $mail, $registrationTime)"
}
