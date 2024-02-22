package com.example.demo.Utils.Feign;

import com.example.demo.Utils.Exception.ErrorDisplay;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String methodKey, Response response) {
        ErrorDisplay message;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ErrorDisplay.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return switch (response.status()) {
            case 400 -> new DataNotValidException(message.getError() != null ? message.getError() : "Bad Request");
            case 404 -> new DataNotFoundException(message.getError() != null ? message.getError() : "Not found");
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
