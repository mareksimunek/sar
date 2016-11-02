package cz.fav.sar.server.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration

@ImportResource({ "classpath:Beans.xml" })
public class RepositoryConfig {

	@Bean("dataSource")
	public static DriverManagerDataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
				DBConfig.URL, 
				DBConfig.USERNAME, 
				DBConfig.PASSWORD);

		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		return driverManagerDataSource;

	}

}