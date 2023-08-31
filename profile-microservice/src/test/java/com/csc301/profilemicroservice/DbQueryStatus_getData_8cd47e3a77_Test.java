package com.csc301.profilemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DbQueryStatus_getData_8cd47e3a77_Test {

    @Mock
    private DbQueryStatus dbQueryStatus;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetData_Success() {
        String expectedData = "Success Data";
        Mockito.when(dbQueryStatus.getData()).thenReturn(expectedData);

        Object actualData = dbQueryStatus.getData();
        Assertions.assertEquals(expectedData, actualData, "Expected data does not match actual data");
    }

    @Test
    public void testGetData_Null() {
        Mockito.when(dbQueryStatus.getData()).thenReturn(null);

        Object actualData = dbQueryStatus.getData();
        Assertions.assertNull(actualData, "Expected data to be null");
    }
}
