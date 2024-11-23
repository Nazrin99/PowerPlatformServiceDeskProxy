package com.example.servicedeskapi.service;

import com.example.servicedeskapi.model.Request;
import com.example.servicedeskapi.payload.request.RequestBody;
import org.springframework.stereotype.Component;

@Component
public interface ServiceDeskService {
    Request getRequestByRequestId(Integer requestId);

    Request createRequest(RequestBody requestBody);
}