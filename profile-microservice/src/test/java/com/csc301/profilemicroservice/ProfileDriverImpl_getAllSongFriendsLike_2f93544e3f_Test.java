package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Value;
import org.neo4j.driver.Result;

public class ProfileDriverImpl_getAllSongFriendsLike_2f93544e3f_Test {

    Driver driver = mock(Driver.class);
    Session session = mock(Session.class);
    Transaction transaction = mock(Transaction.class);
    Result result = mock(Result.class);
    Record record = mock(Record.class);
    Value value = mock(Value.class);

    ProfileDriverImpl profileDriver;

    @BeforeEach
    public void setup() {
        profileDriver = new ProfileDriverImpl();
    }

    @Test
    public void testGetAllSongFriendsLike_success() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), anyMap())).thenReturn(result);
        when(result.hasNext()).thenReturn(true);
        when(result.next()).thenReturn(record);
        when(record.get("userName")).thenReturn(value);
        when(record.get("songs")).thenReturn(value);

        DbQueryStatus dbQueryStatus = profileDriver.getAllSongFriendsLike("John");
        assertEquals(DbQueryExecResult.QUERY_OK, dbQueryStatus.getdbQueryExecResult());
    }

    @Test
    public void testGetAllSongFriendsLike_userNotFound() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), anyMap())).thenReturn(result);
        when(result.hasNext()).thenReturn(false);

        DbQueryStatus dbQueryStatus = profileDriver.getAllSongFriendsLike("John");
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, dbQueryStatus.getdbQueryExecResult());
    }

    @Test
    public void testGetAllSongFriendsLike_exceptionThrown() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), anyMap())).thenThrow(new RuntimeException("Some error occurred"));

        DbQueryStatus dbQueryStatus = profileDriver.getAllSongFriendsLike("John");
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, dbQueryStatus.getdbQueryExecResult());
        assertEquals("Some error occurred", dbQueryStatus.getMessage());
    }
}
