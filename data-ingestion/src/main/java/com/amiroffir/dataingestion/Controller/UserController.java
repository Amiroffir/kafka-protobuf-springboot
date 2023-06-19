package com.amiroffir.dataingestion.Controller;

import com.amiroffir.dataingestion.Model.JSONUser;
import com.amiroffir.dataingestion.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/ingest")
    public ResponseEntity<String> ingestData(@RequestBody JSONUser userData) {
        try {
            // Convert the received JSON data to Protobuf message
       //     User protoUser = userData.toProtoUser();

           // Call the service that will publish the message to Kafka
            userService.publishMessageToKafka("user");

            return ResponseEntity.ok("Data ingested successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while ingesting data");
        }
    }
}