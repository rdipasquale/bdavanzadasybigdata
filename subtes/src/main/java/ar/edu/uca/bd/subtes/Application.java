package ar.edu.uca.bd.subtes;

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

//    
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Application.class, args);
//    }

//	   @Value("${spring.datasource.username}")
//	   private String user;
//	 
//	   @Value("${spring.datasource.password}")
//	   private String password;
//	 
//	   @Value("${spring.datasource.url}")
//	   private String dataSourceUrl;
//	 
//	   @Value("${spring.datasource.dataSourceClassName}")
//	   private String dataSourceClassName;
//	 
//	   @Value("${spring.datasource.poolName}")
//	   private String poolName;
//	 
//	   @Value("${spring.datasource.connectionTimeout}")
//	   private int connectionTimeout;
//	 
//	   @Value("${spring.datasource.maxLifetime}")
//	   private int maxLifetime;
//	 
//	   @Value("${spring.datasource.maximumPoolSize}")
//	   private int maximumPoolSize;
//	 
//	   @Value("${spring.datasource.minimumIdle}")
//	   private int minimumIdle;
//	 
//	   @Value("${spring.datasource.idleTimeout}")
//	   private int idleTimeout;
//	 
//	   @Bean
//	   @Profile("prod")
//	   public DataSource dataSourceProest() {
//	       Properties dsProps = new Properties();
//	       dsProps.put("url", dataSourceUrl);
//	       dsProps.put("user", user);
//	       dsProps.put("password", password);
//	       //dsProps.put("prepStmtCacheSize",250);
//	       //dsProps.put("prepStmtCacheSqlLimit",2048);
//	       //dsProps.put("cachePrepStmts",Boolean.TRUE);
//	       //dsProps.put("useServerPrepStmts",Boolean.TRUE);
//	 
//	       Properties configProps = new Properties();
//	          configProps.put("dataSourceClassName", dataSourceClassName);
//	          configProps.put("poolName",poolName);
//	          configProps.put("maximumPoolSize",maximumPoolSize);
//	          configProps.put("minimumIdle",minimumIdle);
//	          configProps.put("minimumIdle",minimumIdle);
//	          configProps.put("connectionTimeout", connectionTimeout);
//	          configProps.put("idleTimeout", idleTimeout);
//	          configProps.put("dataSourceProperties", dsProps);
//	          
//	 
//	      HikariConfig hc = new HikariConfig(configProps);
//	      HikariDataSource ds = new HikariDataSource(hc);
//	      return ds;
//	   }


//}