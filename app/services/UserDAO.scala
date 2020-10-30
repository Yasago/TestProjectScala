package services

import scala.collection.mutable

object UserDAO {

  private val userMap: mutable.HashMap[String, User] = new mutable.HashMap[String, User]()
  userMap.put("yao", new User("User1", "yao", "fsdf@mail.ru"))
  userMap.put("ewr", new User("User2", "ewr", "qwe@mail.ru"))

  def getUser(login: String): Option[User] = userMap.get(login)

  def addUser(user: User): Option[User] = userMap.put(user.getLogin, user)

  def getAllUsers: List[User] = userMap.values.toList

  def updateUser(user: User): Option[User] = userMap.put(user.getLogin, user)

  def deleteUser(login: String): Option[User] = userMap.remove(login)
}