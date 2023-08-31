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
public class PlaylistDriverImpl_deleteSongFromDb_009b5cd9db_Test {

    @Mock
    private Driver driver;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    @Mock
    private StatementResult statementResult;

    @InjectMocks
    private PlaylistDriverImpl playlistDriverImpl;

    @Before
    public void setup() {
        when(driver.session()).thenReturn(session);
        when(session.writeTransaction(any())).thenReturn(transaction);
    }

    @Test
    public void deleteSongFromDb_Success() {
        String songId = "123"; // TODO: replace with actual songId
        when(session.writeTransaction(any())).thenReturn(statementResult);
        DbQueryStatus result = playlistDriverImpl.deleteSongFromDb(songId);
        assertEquals("DELETE", result.getMessage());
        assertEquals(DbQueryExecResult.QUERY_OK, result.getdbQueryExecResult());
    }

    @Test
    public void deleteSongFromDb_Failure() {
        String songId = "123"; // TODO: replace with actual songId
        when(session.writeTransaction(any())).thenThrow(new RuntimeException());
        DbQueryStatus result = playlistDriverImpl.deleteSongFromDb(songId);
        assertEquals("DELETE", result.getMessage());
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, result.getdbQueryExecResult());
    }
}
