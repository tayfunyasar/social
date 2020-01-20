package com.social.app.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration extends AbstractR2dbcConfiguration {

    @Value("${spring.r2dbc.database}")
      String database;
    @Value("${spring.r2dbc.username}")
    String username;
    @Value("${spring.r2dbc.password}")
    String password;
    @Value("${spring.r2dbc.host}")
    String host;
    @Value("${spring.r2dbc.port}")
    Integer port;

    // r2dbc
    @Override
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .username(username)
                .password(password)
                .database(database)
                .build());
    }

    // rdbc for flyway
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://" + host + ":" + port + "/" + database);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

    // flyway
    @Bean
    public FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
        return new FlywayMigrationInitializer(flyway, (f) ->{
            f.clean();
            f.migrate();
        } );
    }
}