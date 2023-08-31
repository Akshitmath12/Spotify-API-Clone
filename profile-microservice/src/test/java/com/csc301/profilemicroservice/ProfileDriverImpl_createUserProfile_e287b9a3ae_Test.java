package com.csc301.profilemicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.neo4j.driver.v1.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProfileDriverImpl_createUserProfile_e287b9a3ae_Test {

    @Mock
    private Driver driver;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private ProfileDriverImpl profileDriverImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        profileDriverImpl = new ProfileDriverImpl();
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void createUserProfile_Success() {
        // TODO: Change these values to match your test case
        String userName = "testUser";
        String fullName = "testFullName";
        String password = "testPassword";

        DbQueryStatus result = profileDriverImpl.createUserProfile(userName, fullName, password);
        assertEquals(DbQueryExecResult.QUERY_OK, result.getdbQueryExecResult());
    }

    @Test
    public void createUserProfile_Failed_NullParameters() {
        // Test with null parameters
        DbQueryStatus result = profileDriverImpl.createUserProfile(null, null, null);
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, result.getdbQueryExecResult());
    }

    @Test
    public void createUserProfile_Failed_ExceptionThrown() {
        // TODO: Change these values to match your test case
        String userName = "testUser";
        String fullName = "testFullName";
        String password = "testPassword";

        // Mock an exception
        when(session.writeTransaction(any(TransactionWork.class))).thenThrow(new RuntimeException());

        DbQueryStatus result = profileDriverImpl.createUserProfile(userName, fullName, password);
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, result.getdbQueryExecResult());
    }
}
