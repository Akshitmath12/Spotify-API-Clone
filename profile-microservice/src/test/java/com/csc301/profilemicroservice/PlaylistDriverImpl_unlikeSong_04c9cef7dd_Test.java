package com.csc301.profilemicroservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistDriverImpl_unlikeSong_04c9cef7dd_Test {

    @InjectMocks
    PlaylistDriverImpl playlistDriverImpl;

    @Mock
    Driver driver;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    @Mock
    StatementResult result;

    @Before
    public void setup() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testUnlikeSong_InvalidInput() {
        DbQueryStatus status = playlistDriverImpl.unlikeSong(null, null);
        assertEquals(DbQueryStatus.DbQueryExecResult.QUERY_ERROR_GENERIC, status.getdbQueryExecResult());
    }

    @Test
    public void testUnlikeSong_ValidInput() {
        when(transaction.run(anyString(), anyMap())).thenReturn(result);
        when(result.hasNext()).thenReturn(true);

        DbQueryStatus status = playlistDriverImpl.unlikeSong("userName", "songId");
        assertEquals(DbQueryStatus.DbQueryExecResult.QUERY_OK, status.getdbQueryExecResult());
    }

    @Test
    public void testUnlikeSong_Exception() {
        when(transaction.run(anyString(), anyMap())).thenThrow(new RuntimeException());

        DbQueryStatus status = playlistDriverImpl.unlikeSong("userName", "songId");
        assertEquals(DbQueryStatus.DbQueryExecResult.QUERY_ERROR_GENERIC, status.getdbQueryExecResult());
    }
}
