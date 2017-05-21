package pe.com.microservice.taxiboot.web.config;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.planetj.servlet.filter.compression.CompressingFilter;

import pe.com.microservice.taxiboot.web.filter.AccessFilter;


@Configuration
@ComponentScan({ "pe.com.microservice.taxiboot.web" })
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/**
	 * Método configureContentNegotiation
	 * @param configurer
	 */
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		super.configureContentNegotiation(configurer);
		configurer.favorParameter(true);
	}
	
	
	/**
	 * Método configureContentNegotiation
	 * @return filterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}

	
	/**
	 * Método compressingFilter
	 * @return Filter
	 */
	@Bean
	public Filter compressingFilter() {
		return new CompressingFilter();
	}

	
	/**
	 * Método accessFilterRegistration
	 * @return FilterRegistrationBean
	 * registration.addInitParameter("appKey", "taxiboox");
	 */
	@Bean
	public FilterRegistrationBean accessFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(accessFilter());
		registration.addInitParameter("appKey", "booxagency");
		registration.addUrlPatterns("/rest/*");
		registration.setName("accessFilter");
		return registration;
	}

	/**
	 * Método accessFilter
	 * @return SecurityAccessFilter
	 */
	@Bean(name = "accessfilter")
 	public AccessFilter accessFilter() {
		return new AccessFilter();
 
	}
	
	/**
	@Bean(name = "loggingFilter")
 	public LoggingFilter loggingFilter() { 
		return new LoggingFilter();
	}
	 */

}
