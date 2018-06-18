package kamon.spring.instrumentation

import kamon.spring.instrumentation.advisor.ServletHandlerAdvisor
import kanela.agent.scala.KanelaInstrumentation


class ServerInstrumentation  extends KanelaInstrumentation {

  forTargetType("org.eclipse.jetty.servlet.ServletHandler") { builder =>
    builder
      .withAdvisorFor(method("initialize"), classOf[ServletHandlerAdvisor])
      .build()
  }

}
