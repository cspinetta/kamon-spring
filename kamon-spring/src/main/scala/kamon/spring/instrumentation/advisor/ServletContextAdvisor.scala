package kamon.spring.instrumentation.advisor

import java.util

import javax.servlet.DispatcherType
import kamon.servlet.v3.KamonFilterV3
import kanela.agent.libs.net.bytebuddy.asm.Advice
import kanela.agent.libs.net.bytebuddy.implementation.bind.annotation.RuntimeType
import org.eclipse.jetty.servlet.{FilterHolder, ServletContextHandler}

//class ServletContextAdvisor
//object ServletContextAdvisor {
//
//  @RuntimeType
//  @Advice.OnMethodExit()
//  def exitConstructor(@Advice.This servletContext: Object): Unit = {
//    println(s"******************************************************* ServletContextAdvisor")
//    val filterHolder = new FilterHolder(classOf[KamonFilterV3])
//    val servlet = servletContext.asInstanceOf[ServletContextHandler]
//    servlet.addFilter(filterHolder,"/*", util.EnumSet.allOf(classOf[DispatcherType]))
//  }
//
//}
