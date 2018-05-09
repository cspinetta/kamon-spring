package kamon.spring.auto

import kamon.servlet.v3.KamonFilterV3
import org.springframework.boot.autoconfigure.condition.{ConditionalOnProperty, ConditionalOnWebApplication}
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.{Bean, Configuration}


@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(name = Array("kamon.spring.web.enabled"), havingValue = "true", matchIfMissing = true)
class KamonSpringAuto {

  @Bean
  def kamonFilterRegistration: FilterRegistrationBean[KamonFilterV3] = {
    val registrationBean = new FilterRegistrationBean[KamonFilterV3]
    registrationBean.setFilter(new KamonFilterV3)
    registrationBean.addUrlPatterns("/*")
    registrationBean.setEnabled(true)
    registrationBean.setName("kamonFilter")
    registrationBean.setAsyncSupported(true)
    registrationBean.setOrder(Int.MinValue)
    registrationBean
  }

}
