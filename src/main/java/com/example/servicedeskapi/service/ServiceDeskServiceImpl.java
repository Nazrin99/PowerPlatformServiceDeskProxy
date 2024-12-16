package com.example.servicedeskapi.service;

import com.example.servicedeskapi.connection.Connection;
import com.example.servicedeskapi.connection.KeyType;
import com.example.servicedeskapi.model.Request;
import com.example.servicedeskapi.payload.request.*;
import com.example.servicedeskapi.payload.response.AssignRequestResponseBody;
import com.example.servicedeskapi.payload.response.GetTechniciansResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@Service
public class ServiceDeskServiceImpl implements ServiceDeskService{

    @Override
    public GetTechniciansResponseBody getTechnicians() {
        HttpsURLConnection connection;

        try {
            connection = Connection.getConnection("/technicians", HttpMethod.GET, KeyType.AUTH_TOKEN);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                GetTechniciansResponseBody technicians = objectMapper.readValue(connection.getInputStream(), GetTechniciansResponseBody.class);
                System.out.println("Technicians successfully retrieved.");
                return technicians;
            } else {
                throw new RuntimeException("Failed to get technicians: HTTP error code : " + responseCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

        CreateRequestBody createRequestBody = new CreateRequestBody(subject, description);

        try {
            connection = Connection.getConnection("/requests?input_data=" + jsonifyMinifyAndUrlEncode(createRequestBody), HttpMethod.POST, KeyType.AUTH_TOKEN);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_CREATED) {
                ObjectMapper objectMapper = new ObjectMapper();
                Request request = objectMapper.readValue(connection.getInputStream(), Request.class);
                System.out.println("Request ID: " + request.getRequestDetails().getId() + " successfully created.");
                return request;
            } else {
                try (FileWriter fw = new FileWriter("log.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println("Failed to get request: HTTP error code : " + responseCode + "\nError message: " + connection.getResponseMessage());
                } catch (IOException logException) {
                    logException.printStackTrace();
                }

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

    @Override
    public AssignRequestResponseBody assignRequest(Integer requestId, String technicianName) {
        HttpsURLConnection connection;

        AssignRequestBody assignRequestBody = new AssignRequestBody(technicianName);

        try {
            connection = Connection.getConnection("/requests/" + requestId + "/assign?input_data=" + jsonifyMinifyAndUrlEncode(assignRequestBody), HttpMethod.PUT, KeyType.AUTH_TOKEN);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                AssignRequestResponseBody request = objectMapper.readValue(connection.getInputStream(), AssignRequestResponseBody.class);
                System.out.println("Request ID: " + requestId + " successfully assigned to technician: " + technicianName);
                return request;
            } else {
                try (FileWriter fw = new FileWriter("log.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println("Failed to get request: HTTP error code : " + responseCode + "\nError message: " + connection.getResponseMessage());
                } catch (IOException logException) {
                    logException.printStackTrace();
                }

                throw new RuntimeException("Failed to get request: HTTP error code : " + responseCode + "\nError message: " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AssignRequestResponseBody closeRequest(Integer requestId, boolean requesterAckResolution, String requesterAckComments, String closureComments) {
        HttpsURLConnection connection;

        CloseRequestBody closeRequestBody = new CloseRequestBody(requesterAckResolution, requesterAckComments, closureComments);

        try {
            connection = Connection.getConnection("/requests/" + requestId + "/close?input_data=" + jsonifyMinifyAndUrlEncode(closeRequestBody), HttpMethod.PUT, KeyType.AUTH_TOKEN);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                AssignRequestResponseBody request = objectMapper.readValue(connection.getInputStream(), AssignRequestResponseBody.class);
                System.out.println("Request ID: " + requestId + " successfully closed.");
                return request;
            } else {
                // Log the error to a file
                try (FileWriter fw = new FileWriter("log.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println("Failed to get request: HTTP error code : " + responseCode + "\nError message: " + connection.getResponseMessage());
                } catch (IOException logException) {
                    logException.printStackTrace();
                }
                throw new RuntimeException("Failed to get request: HTTP error code : " + responseCode + "\nError message: " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
