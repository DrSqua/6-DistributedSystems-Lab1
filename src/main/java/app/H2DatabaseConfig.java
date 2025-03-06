package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class H2DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:testdb") // In-memory database
                .driverClassName("org.h2.Driver")
                .username("sa") // Default H2 username
                .password("") // No password by default
                .build();
    }
}
