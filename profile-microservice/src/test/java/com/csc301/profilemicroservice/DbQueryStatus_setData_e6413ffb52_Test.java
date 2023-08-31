package com.csc301.profilemicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DbQueryStatus_setData_e6413ffb52_Test {

    private DbQueryStatus dbQueryStatus;

    @BeforeEach
    public void setUp() {
        String message = "Test Message";
        DbQueryExecResult queryExecResult = new DbQueryExecResult();
        dbQueryStatus = new DbQueryStatus(message, queryExecResult);
    }

    @Test
    public void testSetDataWithNonNullObject() {
        String expectedData = "Test Data";
        dbQueryStatus.setData(expectedData);
        assertEquals(expectedData, dbQueryStatus.getData());
    }

    @Test
    public void testSetDataWithNullObject() {
        dbQueryStatus.setData(null);
        assertNull(dbQueryStatus.getData());
    }
}
