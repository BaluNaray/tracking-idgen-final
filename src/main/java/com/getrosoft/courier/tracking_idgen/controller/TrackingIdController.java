package com.getrosoft.courier.tracking_idgen.controller;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getrosoft.courier.tracking_idgen.dto.TrackingIdGenRequestData;
import com.getrosoft.courier.tracking_idgen.service.TrackingIdService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class TrackingIdController {
	
	private TrackingIdService trackingIdService;

	@Autowired
    public TrackingIdController(TrackingIdService trackingIdService) {
        this.trackingIdService = trackingIdService;
    }

    @GetMapping("/next-tracking-number")
    public ResponseEntity<Map<String, String>> generateTrackingNumber(
    		@Valid TrackingIdGenRequestData request)   	
    {    	
    	
        String trackingNumber = trackingIdService.generateTrackingNumber();
        System.out.println("trackingNumber = "+trackingNumber);
        
        System.out.println("Time = "+request.getCreatedAt()+"-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
        //yyyy-MM-dd'T'HH:mmX
        Instant createdAt = Instant.parse(request.getCreatedAt().format(formatter));
                
        Map<String, String> response = Map.of(
                "tracking_number", trackingNumber,
                "created_at", createdAt.toString()
        );

        return ResponseEntity.ok(response);
    }

}
