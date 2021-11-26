package com.todolist.MyToDoList.Config;

import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;


@Profile(value = "mongo")
@Configuration
@Import(EmbeddedMongoAutoConfiguration.class)
public class MongoConfig {
}

