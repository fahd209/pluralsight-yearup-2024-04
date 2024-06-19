package com.pluralsight.Configration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    DataSource dataSource;

    @Bean
    public DataSource getDataSource()
    {
        return this.dataSource;
    }

    public DataSourceConfig(@Value("${db.connectionString}") String url,
                            @Value("${db.username}") String username,
                            @Value("${db.password}")String password

    )
    {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        this.dataSource = basicDataSource;
    }
}
