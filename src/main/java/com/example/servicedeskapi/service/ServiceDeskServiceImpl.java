package com.example.servicedeskapi.service;

import com.example.servicedeskapi.connection.Connection;
import com.example.servicedeskapi.connection.KeyType;
import com.example.servicedeskapi.model.Request;
import com.example.servicedeskapi.payload.request.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Logger;

@Service
public class ServiceDeskServiceImpl implements ServiceDeskService{

	@Override
	public Request getRequestByRequestId(Integer requestId) {
		HttpsURLConnection connection;

		try {
			connection = Connection.getConnection("/requests/" + requestId, HttpMethod.GET, KeyType.AUTH_TOKEN);

			int responseCode = connection.getResponseCode();

			if (responseCode == HttpsURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                Request request = objectMapper.readValue(connection.getInputStream(), Request.class);
                System.out.println("Request ID: " + request.getRequestDetails().getId() + " successfully retrieved.");
                return request;
            } else {
                throw new RuntimeException("Failed to get request: HTTP error code : " + responseCode);
            }
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Request createRequest(String subject, String description) {
        HttpsURLConnection connection;



        try {
            connection = Connection.getConnection("/requests?input_data=" + jsonifyMinifyAndUrlEncode(requestBody), HttpMethod.POST, KeyType.AUTH_TOKEN);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_CREATED) {
                ObjectMapper objectMapper = new ObjectMapper();
                Request request = objectMapper.readValue(connection.getInputStream(), Request.class);
                System.out.println("Request ID: " + request.getRequestDetails().getId() + " successfully created.");
                return request;
            } else {
                throw new RuntimeException("Failed to get request: HTTP error code : " + responseCode + "\nError message: " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String jsonifyMinifyAndUrlEncode(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(object);
            return URLEncoder.encode(jsonString, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
