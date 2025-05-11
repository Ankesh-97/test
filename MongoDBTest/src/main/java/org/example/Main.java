package org.example;

import com.mongodb.BasicDBList;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.include;
import static java.util.Arrays.asList;


public class Main {
    public static void main(String[] args) {

//        SpringApplication.run(Main.class, args);

        MongoClient mongoClient = MongoClients.create("mongodb+srv://root:root@cluster0.pbrouk0.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase mongoDatabase =mongoClient.getDatabase("sample_mflix");
        MongoCollection collection =mongoDatabase.getCollection("movies");
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "sample_airbnb");
//        mongoTemplate.createCollection("testCollection");
//        mongoTemplate.insert(new CollectionName("John", "New York", "1234567890"), "testCollection");
//
        FindIterable itr = collection.find(and(eq("genres","Action"), eq("genres","Drama"))).projection(include("title","genres"));
        while(itr.iterator().hasNext()) {
            System.out.println(itr.iterator().next());
        }

        System.out.println("mongoTemplate.getConverter().getMappingContext().getPersistentEntities() = " + mongoTemplate.getConverter().getMappingContext().getPersistentEntities());
    }
}