package br.com.desafio.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcConfig {

    @Autowired
    private DataSourceProperties properties;
    
	@Value("${USERNAME_DB}")
	private String username;
	
	@Value("${PASSWORD_DB}")
	private String password;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {

        DataSourceBuilder factory = DataSourceBuilder.create(this.properties.getClassLoader())
                .driverClassName(this.properties.getDriverClassName()).url(this.properties.getUrl())
                .username(username)
                .password(password);

        return factory.build();
    }
    
    
}
