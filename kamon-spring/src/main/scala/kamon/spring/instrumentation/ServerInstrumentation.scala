package kamon.spring.instrumentation

import kamon.spring.instrumentation.advisor.{JettyServletHandlerAdvisor, TomcatServletHandlerAdvisor}
import kanela.agent.scala.KanelaInstrumentation


class ServerInstrumentation  extends KanelaInstrumentation {

  forTargetType("org.eclipse.jetty.servlet.ServletHandler") { builder =>
    builder
      .withAdvisorFor(method("initialize"), classOf[JettyServletHandlerAdvisor])
      .build()
  }

  forSubtypeOf("org.apache.catalina.core.StandardContext") { builder =>
    builder
      .withAdvisorFor(method("filterStart"), classOf[TomcatServletHandlerAdvisor])
      .build()
  }

}
