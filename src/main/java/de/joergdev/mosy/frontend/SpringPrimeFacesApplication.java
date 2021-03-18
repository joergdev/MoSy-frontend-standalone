package de.joergdev.mosy.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import de.joergdev.mosy.frontend.utils.LoginFilter;
import de.joergdev.mosy.frontend.utils.RoutingFilter;

@SpringBootApplication
public class SpringPrimeFacesApplication
{
  public static void main(String[] args)
  {
    SpringApplication.run(SpringPrimeFacesApplication.class, args);
  }

  @Bean
  public FilterRegistrationBean<RoutingFilter> routingFilter()
  {
    FilterRegistrationBean<RoutingFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(new RoutingFilter());
    registration.addUrlPatterns("*.xhtml", "*.html");

    return registration;
  }

  @Bean
  public FilterRegistrationBean<LoginFilter> loginFilter()
  {
    FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(new LoginFilter());
    registration.addUrlPatterns("*.xhtml");

    return registration;
  }
}