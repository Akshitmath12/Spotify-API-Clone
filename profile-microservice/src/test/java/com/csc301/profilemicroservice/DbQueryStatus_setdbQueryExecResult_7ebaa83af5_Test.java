package com.csc301.profilemicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DbQueryStatus_setdbQueryExecResult_7ebaa83af5_Test {

    private DbQueryStatus dbQueryStatus;
    private DbQueryExecResult dbQueryExecResultMock;

    @BeforeEach
    public void setup() {
        dbQueryExecResultMock = Mockito.mock(DbQueryExecResult.class);
        dbQueryStatus = new DbQueryStatus("Test Message", dbQueryExecResultMock);
    }

    @Test
    public void testSetDbQueryExecResult_success() {
        dbQueryStatus.setdbQueryExecResult(dbQueryExecResultMock);
        assertEquals(dbQueryExecResultMock, dbQueryStatus.getdbQueryExecResult());
    }

    @Test
    public void testSetDbQueryExecResult_null() {
        dbQueryStatus.setdbQueryExecResult(null);
        assertEquals(null, dbQueryStatus.getdbQueryExecResult());
    }
}
