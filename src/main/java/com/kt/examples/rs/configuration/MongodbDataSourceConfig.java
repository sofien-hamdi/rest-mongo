package com.kt.examples.rs.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
//@PropertySource({"classpath:mongo.properties"})
public class MongodbDataSourceConfig extends AbstractMongoConfiguration {

  @Autowired
  Environment env;

  @Override
  public String getDatabaseName() {
    return env.getRequiredProperty("spring.data.mongodb.database");
  }

  @Override
  public @Bean Mongo mongo() throws Exception {

    ServerAddress serverAddress = new ServerAddress(env.getRequiredProperty("spring.data.mongodb.host"));
    List<MongoCredential> credentials = new ArrayList<>();
    credentials.add(MongoCredential.createCredential(
        env.getRequiredProperty("spring.data.mongodb.username"),
        env.getRequiredProperty("spring.data.mongodb.database"),
        env.getRequiredProperty("spring.data.mongodb.password").toCharArray()));
    MongoClientOptions options = new MongoClientOptions.Builder().build();
    return new MongoClient(serverAddress, credentials, options);
  }

}
