package com.csc301.profilemicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbQueryStatus_setMessage_a4320850bf_Test {

    private DbQueryStatus dbQueryStatus;
    private DbQueryExecResult dbQueryExecResult;

    @Mock
    private DbQueryExecResult mockDbQueryExecResult;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dbQueryExecResult = mockDbQueryExecResult;
        dbQueryStatus = new DbQueryStatus("Test message", dbQueryExecResult);
    }

    @Test
    public void testSetMessageSuccess() {
        String expectedMessage = "Test message";
        dbQueryStatus.setMessage(expectedMessage);
        assertEquals(expectedMessage, dbQueryStatus.getMessage());
    }

    @Test
    public void testSetMessageNull() {
        dbQueryStatus.setMessage(null);
        assertEquals(null, dbQueryStatus.getMessage());
    }
}
