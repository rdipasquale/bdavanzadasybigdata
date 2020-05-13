package ar.edu.uca.bd.subtes;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("ar.edu.uca.bd.subtes.services")
@EnableTransactionManagement
@EntityScan("ar.edu.uca.bd.subtes.entities")
@EnableCaching
@EnableAutoConfiguration
@Configuration
@ConfigurationProperties()
@EnableNeo4jRepositories("ar.edu.uca.bd.subtes.repositories")
@Profile({ "embedded", "test" })
public class ApplicationTest {

//	public static void main(String[] args) {
//		SpringApplication.run(ApplicationTest.class, args);
//	}
//	
    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
    	org.neo4j.ogm.config.Configuration config = new Builder().build();
        return config;
    }

	 
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
	    return new org.neo4j.ogm.session.SessionFactory(getConfiguration(), "ar.edu.uca.bd.subtes.entities");
	}
	 
	@Bean
	public Neo4jTransactionManager transactionManager() {
	    return new Neo4jTransactionManager(getSessionFactory());
	}
}

