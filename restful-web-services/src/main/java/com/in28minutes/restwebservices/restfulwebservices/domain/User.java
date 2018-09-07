package com.in28minutes.restwebservices.restfulwebservices.domain;

/*
Creating a User Bean
 */

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date birthDate;
}
