package com.csye6225.demo.controllers;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.*;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        AmazonSNSClient snsClient = new AmazonSNSClient(new ClientConfiguration());
        String topicArn="arn:aws:sns:us-east-1:179107530530:password_reset";

        //subscribe to an SNS topic
        SubscribeRequest subRequest = new SubscribeRequest(topicArn, "email","xu.shua@husky.neu.edu");
        snsClient.subscribe(subRequest);


//publish to an SNS topic
        String msg = "Reset Password Successfully";
        PublishRequest publishRequest = new PublishRequest(topicArn, msg);
        PublishResult publishResult = snsClient.publish(publishRequest);
    }
}