package controllers

import javax.inject._
import play.api.mvc._
import services.CRUD

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an incrementing count to users. The [[CRUD]]
 * object is injected by the Guice dependency injection system.
 */
@Singleton
class CRUDController @Inject()(cc: ControllerComponents,
                               CRUD: CRUD) extends AbstractController(cc) {

  /**
   * Create an action that responds with the [[CRUD]]'s current
   * count. The result is plain text. This `Action` is mapped to
   * `GET /count` requests by an entry in the `routes` config file.
   */
  def count = Action { Ok(CRUD.nextUser().toString) }
}
