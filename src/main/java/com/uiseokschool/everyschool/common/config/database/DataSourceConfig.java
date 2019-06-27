package com.uiseokschool.everyschool.common.config.database;

import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean("readDataSource")
    DataSource readDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("db.datasource.everyschool.read.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("db.datasource.everyschool.read.jdbc-url"));
        dataSource.setUsername(env.getProperty("db.datasource.everyschool.read.username"));
        dataSource.setPassword(env.getProperty("db.datasource.everyschool.read.password"));
        return dataSource;
    }

    @Bean("writeDataSource")
    DataSource writeDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(env.getProperty("db.datasource.everyschool.write.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("db.datasource.everyschool.write.jdbc-url"));
        dataSource.setUsername(env.getProperty("db.datasource.everyschool.write.username"));
        dataSource.setPassword(env.getProperty("db.datasource.everyschool.write.password"));
        return dataSource;
    }

    @Bean("routingDataSource")
    DataSource routingDataSource() {

        ReplicationRoutingDataSource routingDataSource = new ReplicationRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("write", writeDataSource());
        dataSourceMap.put("read", readDataSource());

        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(readDataSource());

        return routingDataSource;
    }

    @Bean("dataSource")
    public DataSource dataSource() {
        return new LazyConnectionDataSourceProxy(routingDataSource());
    }
}
