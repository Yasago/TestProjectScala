package controllers

import javax.inject._
import play.api.libs.json.{JsValue, Json, Writes}
import play.api.mvc._
import services.{User, UserDAO}

@Singleton
class CRUDController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def userReads(json: JsValue): User = {
    val name = (json \ "name").as[String]
    val login = (json \ "login").as[String]
    val mail = (json \ "mail").as[String]
    new User(name, login, mail)
  }

  implicit val userWrites: Writes[User] = (user: User) => Json.obj(
    "name" -> user.getName,
    "login" -> user.getLogin,
    "mail" -> user.getMail,
    "registrationTime" -> user.getRegistrationTime
  )

  def index: Action[AnyContent] = Action {Ok}

  def getAllUsers: Action[AnyContent] = Action{Ok(Json.toJson(UserDAO.getAllUsers))}

  def getUser(login: String): Action[AnyContent] = Action{Ok(Json.toJson(UserDAO.getUser(login)))}

  def deleteUser(login: String): Action[AnyContent] = Action{Ok(Json.toJson(UserDAO.deleteUser(login)))}

  def addUser(): Action[AnyContent] = Action { request =>
    val jsonUser = request.body.asJson.get
    UserDAO.addUser(userReads(jsonUser))
    Ok
  }

  def updateUser(): Action[AnyContent] = Action { request =>
    val jsonUser = request.body.asJson.get
    UserDAO.updateUser(userReads(jsonUser))
    Ok
  }
}
