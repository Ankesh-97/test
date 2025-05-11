package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private int height;
    private Address address;
}
