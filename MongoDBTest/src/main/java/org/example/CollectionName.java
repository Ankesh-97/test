package org.example;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testCollection")
public class CollectionName {
    private String name;
    private String address;
    private String contact;

    public CollectionName(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}
