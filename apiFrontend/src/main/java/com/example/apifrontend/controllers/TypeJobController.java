package com.example.apifrontend.controllers;

import com.example.apifrontend.services.HttpClientAsynchronous;
import com.example.apifrontend.services.NotAuthorizationHeaderException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@RestController
@RequestMapping(name = "", value = "api/typeJob", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeJobController {

    private HttpClientAsynchronous httpClientAsynchronous;

    private String baseUrl = "http://localhost:8080/api/";

    @Autowired
    public TypeJobController(HttpClientAsynchronous httpClientAsynchronous) {
        this.httpClientAsynchronous = httpClientAsynchronous;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> Get(@ApiIgnore @RequestHeader Map<String, String> headers) throws Exception {
        try {
            String url = baseUrl + "typeJob/getAll";
            var respose = this.httpClientAsynchronous.GET(headers, url);
            return new ResponseEntity<>(respose, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof NotAuthorizationHeaderException)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> GetById(@ApiIgnore @RequestHeader Map<String, String> headers) throws Exception {
        try {
            JSONObject respose = this.httpClientAsynchronous.GET(headers, baseUrl);
            return new ResponseEntity<>(respose, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof NotAuthorizationHeaderException)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> Post(@ApiIgnore @RequestHeader Map<String, String> headers, @RequestBody Object data) throws Exception {
        try {
            JSONObject respose = this.httpClientAsynchronous.POST(headers,baseUrl, data);
            return new ResponseEntity<>(respose, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof NotAuthorizationHeaderException)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public ResponseEntity<JSONObject> Put(@ApiIgnore @RequestHeader Map<String, String> headers, @RequestBody Object data) throws Exception {
        try {
            JSONObject respose = this.httpClientAsynchronous.PUT(headers,baseUrl, data);
            return new ResponseEntity<>(respose, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof NotAuthorizationHeaderException)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<JSONObject> Delete(@ApiIgnore @RequestHeader Map<String, String> headers) throws Exception {
        try {
            JSONObject respose = this.httpClientAsynchronous.DELETE(headers, baseUrl);
            return new ResponseEntity<>(respose, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof NotAuthorizationHeaderException)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
