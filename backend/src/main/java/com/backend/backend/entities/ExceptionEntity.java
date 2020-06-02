package com.backend.backend.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@DynamoDBTable(tableName = "exception")
public class ExceptionEntity{

    @DynamoDBHashKey(attributeName = "exId")
    private String id = "1";

    @DynamoDBAttribute(attributeName = "name")
    private String name = null;

    @DynamoDBAttribute(attributeName = "type")
    private String type = null;

//    @DynamoDBAttribute(attributeName = "payload")
//    private Exception payload = null;
    // to store an exception object might make this into JSON

}


