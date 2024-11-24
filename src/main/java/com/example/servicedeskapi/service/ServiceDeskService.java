package com.example.servicedeskapi.service;

import com.example.servicedeskapi.model.Request;
import com.example.servicedeskapi.payload.response.AssignRequestResponseBody;
import org.springframework.stereotype.Component;

@Component
public interface ServiceDeskService {
    Request getRequestByRequestId(Integer requestId);

    Request createRequest(String subject, String description);

    AssignRequestResponseBody assignRequest(Integer requestId, String technicianName);

    AssignRequestResponseBody closeRequest(Integer requestId, boolean requesterAckResolution, String requesterAckComments, String closureComments);
}