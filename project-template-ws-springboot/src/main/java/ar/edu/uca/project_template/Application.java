package ar.edu.uca.project_template;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableJpaRepositories("ar.edu.uca.project_template.repositories")
@EnableTransactionManagement
@ComponentScan
@EnableAutoConfiguration
@Configuration
@ConfigurationProperties()
@EnableCaching
public class Application {

	  @Bean
	  public CacheManager cacheManager() {
	      SimpleCacheManager cacheManager = new SimpleCacheManager();
	      cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("basicCache")));
	      return cacheManager;
	
	  }   
		
	  public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
	  }
}
