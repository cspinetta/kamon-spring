package kamon.spring.webapp

import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext

trait AppSupport {
  private var app = Option.empty[ConfigurableApplicationContext]
  private var _port = Option.empty[Int]

  def startAppAlone(): Unit = startApp(classOf[AppRunner])
  def startAppWithKamon(): Unit = startApp(classOf[AppRunnerWithKamon])

  private def startApp[T](clazz: Class[T]): Unit = {
    val configApp = SpringApplication.run(clazz)
    app = Some(configApp)
    _port = Option(configApp.getEnvironment.getProperty("local.server.port").toInt)
  }

  def stopApp(): Unit = app.foreach(_.close())

  def port: Int = _port.get
}
