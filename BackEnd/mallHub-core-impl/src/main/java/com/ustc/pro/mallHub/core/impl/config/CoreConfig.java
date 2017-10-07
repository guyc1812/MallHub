package com.ustc.pro.mallHub.core.impl.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import java.net.UnknownHostException;




@Configuration
@PropertySource(value = "classpath:properties")
@ComponentScan(basePackages = "com.ustc.pro.mallHub.core")
public class CoreConfig {


    @Primary
    @Bean
    public MongoClient MongoClient(Environment environment) throws UnknownHostException {
        final String mongoUrl = environment.getProperty("mongo.url");
        final String mongoPort = environment.getProperty("mongo.port");
        MongoClient mongoClient = new MongoClient(mongoUrl, Integer.parseInt(mongoPort));
        return mongoClient;
    }


    @Bean
    public PropertySourcesPlaceholderConfigurer propertiesResolver() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
