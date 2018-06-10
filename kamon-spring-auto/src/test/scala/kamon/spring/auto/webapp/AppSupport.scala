package kamon.spring.auto.webapp

import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext

trait AppSupport {
  private var app = Option.empty[ConfigurableApplicationContext]
  private var _port = Option.empty[Int]

  def startApp(): Unit = {
    val configApp = SpringApplication.run(classOf[AppRunner])
    app = Some(configApp)
    _port = Option(configApp.getEnvironment.getProperty("local.server.port").toInt)
  }

  def stopApp(): Unit = app.foreach(_.close())

  def port: Int = _port.get
}
