package org.example.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig {

    @Autowired
    MongoConfigProperties mongoConfigProperties;


    @Bean(name = "mongoClientFactoryBean")
    public MongoClientFactoryBean getMongoFactoryBean() {
        MongoClientFactoryBean mongoClientFactoryBean = new MongoClientFactoryBean();
        mongoClientFactoryBean.setConnectionString(new ConnectionString(mongoConfigProperties.getUri()));
        return mongoClientFactoryBean;
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(getMongoFactoryBean().getObject(), mongoConfigProperties.getDatabase());
    }

}
