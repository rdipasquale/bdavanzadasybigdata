package ar.edu.uca.bases2.mongodomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ComponentScan()
@EnableTransactionManagement
@EntityScan()
@EnableCaching
@EnableAutoConfiguration
@Configuration
@ConfigurationProperties()
@EnableMongoRepositories()
public class MongodomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodomainApplication.class, args);
	}

}



