package kamon.spring.webapp

import java.util

import javax.servlet.DispatcherType
import kamon.servlet.v3.KamonFilterV3
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AppRunner {

  @Bean
  def kamonFilterRegistration(@Value("${kamon.spring.web.enabled}") enabled: Boolean): FilterRegistrationBean = {
    val registrationBean = new FilterRegistrationBean()
    registrationBean.setFilter(new KamonFilterV3)
    registrationBean.addUrlPatterns("/*")
    registrationBean.setEnabled(enabled)
    registrationBean.setName("kamonFilter")
    registrationBean.setDispatcherTypes(util.EnumSet.of(DispatcherType.REQUEST))
    registrationBean.setOrder(Int.MaxValue)
    registrationBean
  }
}
