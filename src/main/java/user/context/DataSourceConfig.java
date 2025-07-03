package user.context;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import user.persistence.UserDao;
import user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class DataSourceConfig {

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        // Конфигурируем соединение
        HikariConfig config = new HikariConfig();

        // Основные параметры подключения
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgresql");
        config.setUsername("postgres");
        config.setPassword("admin");

        // Параметры пула соединений
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTimeout(30_00);
        config.setIdleTimeout(600_00);
        config.setMaxLifetime(1800_00);

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
