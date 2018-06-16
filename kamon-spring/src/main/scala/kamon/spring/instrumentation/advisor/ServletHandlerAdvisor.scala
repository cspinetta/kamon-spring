package kamon.spring.instrumentation.advisor

import java.util

import javax.servlet.DispatcherType
import kamon.servlet.v3.KamonFilterV3
import kanela.agent.libs.net.bytebuddy.asm.Advice
import kanela.agent.libs.net.bytebuddy.implementation.bind.annotation.RuntimeType
import org.eclipse.jetty.servlet.{FilterHolder, ServletHandler}


class ServletHandlerAdvisor
object ServletHandlerAdvisor {

  @RuntimeType
  @Advice.OnMethodEnter()
  def startInitialization(@Advice.This servletHandler: Object): Unit = {
    val filterHolder = new FilterHolder(classOf[KamonFilterV3])
    val servlet = servletHandler.asInstanceOf[ServletHandler]
    servlet.addFilterWithMapping(filterHolder,"/*", util.EnumSet.of(DispatcherType.REQUEST))
  }

}
