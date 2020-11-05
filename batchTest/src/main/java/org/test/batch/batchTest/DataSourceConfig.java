package org.test.batch.batchTest;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Value("${app.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		PGSimpleDataSource ds = new PGSimpleDataSource() ;  
		ds.setServerName( "localhost" );  
		ds.setDatabaseName( "bd2" );   
		ds.setUser( "postgres" );       
		ds.setPassword(this.password);		
		return ds;
	}
}
