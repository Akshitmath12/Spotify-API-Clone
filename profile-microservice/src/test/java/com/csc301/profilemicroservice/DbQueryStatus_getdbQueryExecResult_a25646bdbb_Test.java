package com.csc301.profilemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

public class DbQueryStatus_getdbQueryExecResult_a25646bdbb_Test {

    @Mock
    private DbQueryStatus dbQueryStatus;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetdbQueryExecResult_Success() {
        DbQueryExecResult expectedDbQueryExecResult = DbQueryExecResult.QUERY_OK;
        when(dbQueryStatus.getdbQueryExecResult()).thenReturn(expectedDbQueryExecResult);

        DbQueryExecResult actualDbQueryExecResult = dbQueryStatus.getdbQueryExecResult();

        Assertions.assertEquals(expectedDbQueryExecResult, actualDbQueryExecResult);
    }

    @Test
    public void testGetdbQueryExecResult_Failure() {
        DbQueryExecResult expectedDbQueryExecResult = DbQueryExecResult.QUERY_ERROR_GENERIC;
        when(dbQueryStatus.getdbQueryExecResult()).thenReturn(expectedDbQueryExecResult);

        DbQueryExecResult actualDbQueryExecResult = dbQueryStatus.getdbQueryExecResult();

        Assertions.assertEquals(expectedDbQueryExecResult, actualDbQueryExecResult);
    }
}
