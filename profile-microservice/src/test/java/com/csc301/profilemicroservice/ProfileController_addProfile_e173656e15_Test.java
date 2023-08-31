package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProfileController_addProfile_e173656e15_Test {

    @InjectMocks
    ProfileController profileController;

    @Mock
    ProfileDriverImpl profileDriver;

    @Mock
    HttpServletRequest request;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addProfile_Success() {
        Map<String, String> params = new HashMap<>();
        params.put("userName", "testUser");
        params.put("userFullName", "Test User");
        params.put("userPassword", "test123");

        DbQueryStatus dbQueryStatus = new DbQueryStatus("Success", DbQueryExecResult.QUERY_OK);
        when(profileDriver.createUserProfile(params.get("userName"), params.get("userFullName"), params.get("userPassword"))).thenReturn(dbQueryStatus);
        when(request.getRequestURI()).thenReturn("/profile");

        Map<String, Object> response = profileController.addProfile(params, request);
        assertEquals("POST /profile", response.get("path"));
        assertEquals("Success", response.get("message"));
    }

    @Test
    public void addProfile_Failure() {
        Map<String, String> params = new HashMap<>();
        params.put("userName", "testUser");
        params.put("userFullName", "Test User");
        params.put("userPassword", "test123");

        DbQueryStatus dbQueryStatus = new DbQueryStatus("Failure", DbQueryExecResult.QUERY_ERROR_GENERIC);
        when(profileDriver.createUserProfile(params.get("userName"), params.get("userFullName"), params.get("userPassword"))).thenReturn(dbQueryStatus);
        when(request.getRequestURI()).thenReturn("/profile");

        Map<String, Object> response = profileController.addProfile(params, request);
        assertEquals("POST /profile", response.get("path"));
        assertEquals("Failure", response.get("message"));
    }
}
