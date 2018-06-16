package kamon.spring.webapp

import kamon.servlet.v3.KamonFilterV3
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@SpringBootApplication
class AppRunner {

  @Bean
  def kamonFilterRegistration(@Value("${kamon.spring.web.enabled}") enabled: Boolean): FilterRegistrationBean[KamonFilterV3] = {
    val registrationBean = new FilterRegistrationBean[KamonFilterV3]
    registrationBean.setFilter(new KamonFilterV3)
    registrationBean.addUrlPatterns("/*")
    registrationBean.setEnabled(enabled)
    registrationBean.setName("kamonFilter")
    registrationBean.setAsyncSupported(true)
    registrationBean.setOrder(Int.MinValue)
    registrationBean
  }
}

@Component
class CustomizationBean extends WebServerFactoryCustomizer[ConfigurableServletWebServerFactory] {
  override def customize(server: ConfigurableServletWebServerFactory): Unit = {
    server.setPort(0) // Random port
  }
}
