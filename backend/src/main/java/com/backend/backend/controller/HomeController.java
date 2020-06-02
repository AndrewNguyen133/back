package com.backend.backend.controller;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
// import com.backend.backend.aws.DynamoDBClientFactory;
import com.backend.backend.aws.DynamoDBClientFactoryExcept;
import com.backend.backend.entities.ExceptionEntity;

import com.backend.backend.service.ExceptionEntityService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dynamoTest")
@RequiredArgsConstructor
public class HomeController {

        private final ExceptionEntityService exceptionEntityService;

        @PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public HttpStatus putExceptionObj(@RequestBody @NonNull ExceptionEntity ex) {
            // validate ex
            // look up how to map the RequestBody to an object
            System.out.println(ex);
            exceptionEntityService.saveException(ex);
            return HttpStatus.OK;
        }

        // send in the request body, if set here String it will be a JSON string
        @GetMapping()
        public HttpStatus getExceptionObj(@RequestBody @NonNull String id) {
            // validate ex
            // look up how to map the RequestBody to an object
            System.out.println(id);
            id = "1";
            exceptionEntityService.getExceptionById(id);
            return HttpStatus.OK;
        }

        // send in the request body, if set here String it will be a JSON string
        @GetMapping()
        public HttpStatus getAllExceptions() {
            exceptionEntityService.findAll();
            return HttpStatus.OK;
        }


        @GetMapping("/createTable")
            @ResponseBody
            public String home() {

                String table_name = "exception3";

                CreateTableRequest request = new CreateTableRequest()
                        .withAttributeDefinitions(new AttributeDefinition(
                                "Name", ScalarAttributeType.S))
                        .withKeySchema(new KeySchemaElement("Name", KeyType.HASH))
                        .withProvisionedThroughput(new ProvisionedThroughput(
                                Long.valueOf(10), Long.valueOf(10)))
                        .withTableName(table_name);
                // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/creating-clients.html
                // creating clients docs
                final AmazonDynamoDB ddb = new DynamoDBClientFactoryExcept().amazonDynamoDB();

            try {
                CreateTableResult result = ddb.createTable(request);
                System.out.println(result.getTableDescription().getTableName());
            } catch (AmazonServiceException e) {
                System.err.println(e.getErrorMessage());
                System.exit(1);
            }
            return "Success";
        }


}
