package de.joergdev.mosy.frontend;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import de.joergdev.mosy.frontend.utils.LoginFilter;
import de.joergdev.mosy.frontend.utils.RoutingFilter;

@SpringBootApplication
public class SpringPrimeFacesApplication
{
  private static final Logger LOG = Logger.getLogger(SpringPrimeFacesApplication.class);

  public static void main(String[] args)
  {
    long timeStart = System.currentTimeMillis();
    LOG.info("Booting Application mosy-frontend");

    SpringApplication.run(SpringPrimeFacesApplication.class, args);

    LOG.info("Booted application mosy-frontend in " + (System.currentTimeMillis() - timeStart) + " ms");
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