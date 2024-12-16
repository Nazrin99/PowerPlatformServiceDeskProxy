package com.example.servicedeskapi.web;

import com.example.servicedeskapi.model.Request;
import com.example.servicedeskapi.payload.response.AssignRequestResponseBody;
import com.example.servicedeskapi.payload.response.GetTechniciansResponseBody;
import com.example.servicedeskapi.service.ServiceDeskService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-desk")
@CrossOrigin(maxAge = 3600)
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class ServiceDeskController {

    @Autowired
    ServiceDeskService serviceDeskService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/requests")
    public ResponseEntity<Request> createRequest(
            @RequestParam String subject,
            @RequestParam String description) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceDeskService.createRequest(subject, description));
    }


    @GetMapping("/requests/{requestId}")
    public ResponseEntity<Request> getRequestByRequestId(@PathVariable Integer requestId) {
        return ResponseEntity.ok(serviceDeskService.getRequestByRequestId(requestId));
    }

    @GetMapping("/requests/{requestId}/assign")
    public ResponseEntity<AssignRequestResponseBody> assignRequest(@PathVariable Integer requestId, @RequestParam String technicianName) {
        return ResponseEntity.ok(serviceDeskService.assignRequest(requestId, technicianName));
    }

    @GetMapping("/requests/{requestId}/close")
    public ResponseEntity<AssignRequestResponseBody> closeRequest(@PathVariable Integer requestId, @RequestParam boolean requesterAckResolution, @RequestParam String requesterAckComments, @RequestParam String closureComments) {
        return ResponseEntity.ok(serviceDeskService.closeRequest(requestId, requesterAckResolution, requesterAckComments, closureComments));
    }

    @GetMapping("/technicians")
    public ResponseEntity<GetTechniciansResponseBody> getTechnicians() {
        return ResponseEntity.ok(serviceDeskService.getTechnicians());
    }
}