package pe.com.microservice.taxiboot.web.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.WebApplicationInitializer;
import de.codecentric.boot.admin.model.Application;


@Configuration
@ComponentScan("pe.com.microservice.taxiboot.*")
@EnableAutoConfiguration
//@SpringBootApplication
public class InitApplication extends SpringBootServletInitializer implements
			WebApplicationInitializer {

	//@Value("${util.application.datasource.rewards.jndi-name}")
	//private String jndiDatasourceOrcl;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);			    
	}
	
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		String url = "jdbc:mysql://192.69.210.154:3306/booxagen_repository";
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUsername("booxagen_admin");
		datasource.setPassword("1qa2ws3ed");
		datasource.setUrl(url);
		return datasource;
	}
	
	/*
	@Bean
	//@ConfigurationProperties(prefix="datasource.secondary")
	public DataSource dataSourceOrcl() {
		this.jndiDatasourceOrcl = "jdbc/boox";
		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
		jndi.setExpectedType(DataSource.class);
		jndi.setJndiName(jndiDatasourceOrcl);
		try {
			jndi.afterPropertiesSet();
		} catch (NamingException e) {
			logger.error(
					"Error while retrieving datasource with JNDI name jdbc/AppDataSource",
					e);
		}
		return (DataSource) jndi.getObject();

	}
	 */
	
	@Bean
	public JdbcTemplate jdbcTemplateMySql() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		//jdbcTemplate.setDataSource(dataSourceOrcl());
		return jdbcTemplate;
	}
	 
	
}
