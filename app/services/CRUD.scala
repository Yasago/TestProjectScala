package services

import java.util.Calendar
import java.util.concurrent.atomic.AtomicInteger
import javax.inject._
import scala.collection.mutable.ListBuffer

/**
 * This trait demonstrates how to create a component that is injected
 * into a controller. The trait represents a CRUD that returns a
 * incremented number each time it is called.
 */
trait CRUD {
  def nextUser(): ListBuffer[User]

  def getName(): String
}

/**
 * This class is a concrete implementation of the [[CRUD]] trait.
 * It is configured for Guice dependency injection in the [[Module]]
 * class.
 *
 * This class has a `Singleton` annotation because we need to make
 * sure we only use one CRUD per application. Without this
 * annotation we would get a new instance every time a [[CRUD]] is
 * injected.
 */

@Singleton
class AtomicCRUD extends CRUD {
  var userList: ListBuffer[User] = ListBuffer()
  private val atomicCRUD = new AtomicInteger(0)
  private val name = new String()

  override def nextUser(): ListBuffer[User] = {
    atomicCRUD.getAndAdd(1)
    userList += User("User" + atomicCRUD, "Login", "mail", Calendar.getInstance().get(Calendar.DATE))
  }

  override def getName(): String = name;
}