package ar.edu.uca.bd.template;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan()
@EnableTransactionManagement
@EntityScan
@EnableCaching
@EnableAutoConfiguration
@Configuration
@ConfigurationProperties()
@EnableNeo4jRepositories("ar.edu.uca.bd.template.repositories")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public static final String URL = 
			  System.getenv("NEO4J_URL") != null ? 
			  System.getenv("NEO4J_URL") : "http://neo4j:neo4j@127.0.0.1:7474";
			 
	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
	    return new Builder().uri(URL).build();
	}

	 
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
	    return new org.neo4j.ogm.session.SessionFactory(getConfiguration(), "ar.edu.uca.bd.template.domain");
	}
	 
	@Bean
	public Neo4jTransactionManager transactionManager() {
	    return new Neo4jTransactionManager(getSessionFactory());
	}
}

