package kamon.spring.kanela.instrumentation

import kamon.spring.kanela.instrumentation.advisor.{InterceptingAsyncHttpAccessorAdvisor, InterceptingSyncHttpAccessorAdvisor}
import kanela.agent.scala.KanelaInstrumentation

class ClientInstrumentation extends KanelaInstrumentation {

  forSubtypeOf("org.springframework.http.client.support.InterceptingHttpAccessor") { builder =>
    builder
      .withAdvisorFor(Constructor, classOf[InterceptingSyncHttpAccessorAdvisor])
      .build()
  }

  forSubtypeOf("org.springframework.http.client.support.InterceptingAsyncHttpAccessor") { builder =>
    builder
      .withAdvisorFor(Constructor, classOf[InterceptingAsyncHttpAccessorAdvisor])
      .build()
  }

}
