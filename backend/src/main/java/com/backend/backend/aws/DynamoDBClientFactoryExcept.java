package com.backend.backend.aws;
// To make requests to Amazon Web Services, you first create a service client object.
// The recommended way is to use the service client builder.
// Each AWS service has a service interface with methods for each action in the service API.

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Data
@Component
@Configuration
//@EnableDynamoDBRepositories
//        (basePackages = "com.backend.backend.repository")
@NoArgsConstructor
public class DynamoDBClientFactoryExcept {

//    @Value("cloud.aws.region.static")
//    private String region;
    @Bean
    public AmazonDynamoDB amazonDynamoDB () {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion("us-east-1")
                .withCredentials(new ProfileCredentialsProvider("andrewProfile"))
                .withClientConfiguration(new ClientConfiguration().withRequestTimeout(5000))
                .build();
    }
}
