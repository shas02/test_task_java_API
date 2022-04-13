package com.spring.test_task_java_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @Field("_id")
    private int id;

    @Field("Name")
    private String name;

    @Field("Email")
    @Indexed(unique = true)
    private String email;
}
